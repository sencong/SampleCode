#include "stdafx.h"
#include "Geography.h"


size_t writePoint(char * dest, double x, double y, double z, double m, bool hasZ, bool hasM, size_t & destCap)
{
    destCap -= 16;
    if (hasZ)
            destCap -= 8;
    if (hasM)
            destCap -= 8;
    if (destCap < 0)
            return 0;
    size_t incre = 0;
    memcpy(dest + incre, &x, 8);
    incre += 8;
    memcpy(dest + incre, &y, 8);
    incre += 8;
    if (hasZ)
    {
            memcpy(dest + incre, &z, 8);
            incre += 8;
    }
    if (hasM)
    {
            memcpy(dest + incre, &m, 8);
            incre += 8;
    }
    return incre;
}


size_t writeWKBPoint(char * dest, int code, const char * source, size_t & sIndex, int totalPoints, int offSet, bool hasZ, bool hasM, size_t & destCap)
{
    if (destCap < 5)
            return 0;
    double x = 0;
    double y = 0;
    double z = 0;
    double m = 0;
    dest[0] = 1;
    memcpy(dest + 1, &code, 4);
    destCap -= 5;
    memcpy(&x, source + sIndex + 8, 8);
    memcpy(&y, source + sIndex, 8);
    size_t zbuffIndex = sIndex + 2 * 8 * (totalPoints - offSet) + 8 * offSet;
    size_t mbuffIndex = hasZ ? zbuffIndex + 8 * totalPoints : zbuffIndex;
    sIndex += 16;
    if (hasZ)
            memcpy(&z, source + zbuffIndex, 8);
    if (hasM)
            memcpy(&m, source + mbuffIndex, 8);
    return 5 + writePoint(dest + 5, x, y, z, m, hasZ, hasM, destCap);
}


size_t writeWKBLine(char * dest, int code, const char * source, size_t& sIndex, int totalPoints, int offSet, bool hasZ, bool hasM, int numPoints, size_t & destCap)
{
    if (destCap < 5)
            return 0;
    size_t incre = 0;
    double x = 0;
    double y = 0;
    double z = 0;
    double m = 0;
    dest[0] = 1;
    ++incre;
    memcpy(dest + incre, &code, 4);
    incre += 4;
    destCap -= 5;
    if (destCap < 4)
            return 0;
    memcpy(dest + incre, &numPoints, 4);
    incre += 4;
    destCap -= 4;
    size_t zbuffIndex = sIndex + 2 * 8 * (totalPoints - offSet) + 8 * offSet;
    size_t mbuffIndex = hasZ ? zbuffIndex + 8 * totalPoints : zbuffIndex;
    for (int cnt = 0; cnt < numPoints; ++cnt)
    {
            size_t prev = incre;
            memcpy(&x, source + sIndex + 8, 8);
            incre += 8;
            memcpy(&y, source + sIndex, 8);
            incre += 8;
            sIndex += 16;
            if (hasZ)
            {
                    memcpy(&z, source + zbuffIndex, 8);
                    incre += 8;
                    zbuffIndex += 8;
            }
            if (hasM)
            {
                    memcpy(&m, source + mbuffIndex, 8);
                    incre += 8;
                    mbuffIndex += 8;
            }
            writePoint(dest + prev, x, y, z, m, hasZ, hasM, destCap);
            if (destCap < 0)
                    return 0;
    }
    return incre;
}


size_t writeWKBPoly(char * dest, int code, const char * source, size_t& sIndex, int numPoints, int totalPoints, int offSet, size_t& figSectIndex, int numFigures, bool hasZ, bool hasM, size_t & destCap)
{
    if (destCap < 9)
            return 0;
    size_t incre = 0;
    dest[0] = 1;
    ++incre;
    memcpy(dest + incre, &code, 4);
    incre += 4;
    memcpy(dest + incre, &numFigures, 4);
    incre += 4;
    destCap -= 9;
    int prevStart = 0;
    int curStart = 0;
    int curSize = 0;


    ++figSectIndex;
    memcpy(&curStart, source + figSectIndex, 4);
    figSectIndex += 4;
    for (int figCursor = 0; figCursor < numFigures; ++figCursor)
    {
            if (figCursor != numFigures - 1)
            {
                    prevStart = curStart;
                    ++figSectIndex;
                    memcpy(&curStart, source + figSectIndex, 4);
                    figSectIndex += 4;
                    curSize = curStart - prevStart;
                    numPoints -= curSize;
            }
            else
            {
                    curSize = numPoints;
            }
            if (destCap < 4)
                    return 0;
            destCap -= 4;
            memcpy(dest + incre, &curSize, 4);
            incre += 4;
            size_t zbuffIndex = sIndex + 2 * 8 * (totalPoints - offSet) + 8 * offSet;
            size_t mbuffIndex = hasZ ? zbuffIndex + 8 * totalPoints : zbuffIndex;
            for (size_t counter = 0; counter < curSize; counter++)
            {
                    if (destCap < 8)
                            return 0;
                    destCap -= 8;
                    memcpy(dest + incre, source + sIndex + 8, 8);
                    incre += 8;
                    if (destCap < 8)
                            return 0;
                    destCap -= 8;
                    memcpy(dest + incre, source + sIndex, 8);
                    incre += 8;
                    if (hasZ)
                    {
                            if (destCap < 8)
                                    return 0;
                            destCap -= 8;
                            memcpy(dest + incre, source + zbuffIndex, 8);
                            zbuffIndex += 8;
                            incre += 8;
                    }
                    if (hasM)
                    {
                            if (destCap < 8)
                                    return 0;
                            destCap -= 8;
                            memcpy(dest + incre, source + mbuffIndex, 8);
                            mbuffIndex += 8;
                            incre += 8;
                    }
                    sIndex += 16;
            }
    }
    return incre;
}


size_t writeWKBMPoint(char * dest, int code, const char * source, size_t & sIndex, int numPoints, bool hasZ, bool hasM, size_t & destCap)
{
    if (destCap < 9)
            return 0;
    size_t incre = 0;
    dest[0] = 1;
    ++incre;
    memcpy(dest + incre, &code, 4);
    incre += 4;
    memcpy(dest + incre, &numPoints, 4);
    incre += 4;
    destCap -= 9;
    code = 0001;
    if (hasZ)
            code += 1000;
    if (hasM)
            code += 2000;


    for (int cnt = 0; cnt < numPoints; ++cnt)
    {
            incre += writeWKBPoint(dest + incre, code, source, sIndex, numPoints, cnt, hasZ, hasM, destCap);
            if (destCap < 0)
                    return 0;
    }
    return incre;
}


size_t writeWKBMLine(char * dest, int code, const char * source, size_t& sIndex, int totalPoints, size_t figSectIndex, int totalFigures, bool hasZ, bool hasM, size_t & destCap)
{
    if (destCap < 9)
            return 0;
    size_t incre = 0;
    dest[0] = 1;
    ++incre;
    memcpy(dest + incre, &code, 4);
    incre += 4;
    memcpy(dest + incre, &totalFigures, 4);
    incre += 4;
    destCap -= 9;
    code = 0002;
    if (hasZ)
            code += 1000;
    if (hasM)
            code += 2000;
    int curPointStart = 0;
    int prevPointStart = 0;
    int curPointSize = 0;
    ++figSectIndex;
    memcpy(&curPointStart, source + figSectIndex, 4);
    figSectIndex += 4;
    int offSet = 0;
    for (int cnt = 0; cnt < totalFigures; ++cnt)
    {
            if (cnt != totalFigures - 1)
            {
                    prevPointStart = curPointStart;
                    ++figSectIndex;
                    memcpy(&curPointStart, source + figSectIndex, 4);
                    figSectIndex += 4;
                    curPointSize = curPointStart - prevPointStart;
            }
            else
            {
                    curPointSize = totalPoints - curPointStart;
            }
            incre += writeWKBLine(dest + incre, code, source, sIndex, totalPoints, offSet, hasZ, hasM, curPointSize, destCap);
            if (destCap < 0)
                    return 0;
            offSet += curPointSize;
    }
    return incre;
}


size_t writeWKBMPoly(char * dest, int code, const char * source, size_t& sIndex, int totalPoints, size_t figSectIndex, int totalFigures, size_t& shapeSectIndex, int totalShapes, bool hasZ, bool hasM, size_t & destCap)
{
    if (destCap < 9)
            return 0;
    size_t incre = 0;
    dest[0] = 1;
    ++incre;
    memcpy(dest + incre, &code, 4);
    incre += 4;
    int numPoly = totalShapes - 1; // The MultiPolygon itself will take one extra shape.
    memcpy(dest + incre, &numPoly, 4);
    incre += 4;
    destCap -= 9;
    code = 0003;
    if (hasZ)
            code += 1000;
    if (hasM)
            code += 2000;
    int prevFigStart = 0;
    int curFigStart = 0;
    int curFigSize = 0;
    int curPointStart = 0;
    int prevPointStart = 0;
    int curPointSize = 0;
    int offSet = 0;
    if (totalFigures > 0)
    {
            memcpy(&curFigStart, source + shapeSectIndex + 4, 4);
            shapeSectIndex += 9;
    }
    if (totalPoints > 0)
            memcpy(&curPointStart, source + figSectIndex + 5 * curFigStart + 1, 4);


    for (int shapeCursor = 1; shapeCursor < totalShapes; ++shapeCursor)
    {
            if (shapeCursor != totalShapes - 1)
            {
                    prevFigStart = curFigStart;
                    prevPointStart = curPointStart;
                    memcpy(&curFigStart, source + shapeSectIndex + 4, 4);
                    shapeSectIndex += 9;
                    curFigSize = curFigStart - prevFigStart;
                    memcpy(&curPointStart, source + figSectIndex + 5 * curFigStart + 1, 4);
                    curPointSize = curPointStart - prevPointStart;
            }
            else
            {
                    curFigSize = totalFigures - curFigStart;
                    curPointSize = totalPoints - curPointStart;
            }
            incre += writeWKBPoly(dest + incre, code, source, sIndex, curPointSize, totalPoints, offSet, figSectIndex, curFigSize, hasZ, hasM, destCap);
            if (destCap < 0)
                    return 0;
            offSet += curPointSize;
    }


    return incre;
}
// Converts a raw MSSQL geography binary value to an Extended Well-Known Binary (EWKB)
// format.  The EWKB format used by LFS is WKB with a 4 byte little-endian SRID prefix.
size_t MSSQLGeographyToEWKB(const void* geometry,
                                size_t geometryLength,
                                void* output,
                                size_t outputLength)
{
    const char* sourceBuff = (const char*) geometry;
    char* destBuff = (char*) output;
    if (outputLength < geometryLength)
            return 0;
    if (geometryLength < 6 || outputLength < 5)
            return 0;
    int srid = 0;
    memcpy(&srid, sourceBuff, 4);
    if (srid < 4120 || srid > 4999)
            return 0;
    memcpy(destBuff, &srid, 4);
    size_t sBuffIndex = 4;
    size_t destBuffIndex = 4;
    int numPoints = 0;
    int numFigures = 0;
    int numShapes = 0;
    int doublesPerPoint = 2;
    bool hasZ = false;
    bool hasM = false;
    int version = 0;
    if (sourceBuff[sBuffIndex] == 1)
            version = 1;
    else if (sourceBuff[sBuffIndex] == 2)
            version = 2;
    else
            return 0;
    ++sBuffIndex;
    if (((sourceBuff[sBuffIndex] >> 2) & 1) == 0 && version == 1)
            return 0;
    hasZ = sourceBuff[sBuffIndex] & 1;
    hasM = (sourceBuff[sBuffIndex] >> 1) & 1;
    int code = 0;


    size_t destCap = outputLength - destBuffIndex;
    if ((sourceBuff[sBuffIndex] >> 3) & 1)
    {
            ++sBuffIndex;


            code = 0001;
            if (hasZ)
            {
                    code += 1000;
                    ++doublesPerPoint;
            }




            if (hasM)
            {
                    code += 2000;
                    ++doublesPerPoint;
            }
            if (sBuffIndex + doublesPerPoint * 8 > geometryLength)
                    return 0;


            destBuffIndex += writeWKBPoint(destBuff + destBuffIndex, code, sourceBuff, sBuffIndex, 1, 0, hasZ, hasM, destCap);


    }
    else if ((sourceBuff[sBuffIndex] >> 4) & 1)
    {
            ++sBuffIndex;
            numPoints = 2;
            code = 0002;
            if (hasZ)
            {
                    code += 1000;
                    ++doublesPerPoint;
            }




            if (hasM)
            {
                    code += 2000;
                    ++doublesPerPoint;
            }
            if (sBuffIndex + doublesPerPoint * 8 * numPoints > geometryLength)
                    return 0;
            destBuffIndex += writeWKBLine(destBuff + destBuffIndex, code, sourceBuff, sBuffIndex, 2, 0, hasZ, hasM, numPoints, destCap);
    }


    else
    {
            ++sBuffIndex;
            memcpy(&numPoints, sourceBuff + sBuffIndex, 4);
            sBuffIndex += 4;
            if (hasZ)
                    ++doublesPerPoint;
            if (hasM)
                    ++doublesPerPoint;
            size_t figSectIndex = sBuffIndex + doublesPerPoint * 8 * numPoints;
            if (figSectIndex + 4 > geometryLength)
                    return 0;
            memcpy(&numFigures, sourceBuff + figSectIndex, 4);
            figSectIndex += 4;
            size_t shapeSectIndex = figSectIndex + 5 * numFigures;
            if (shapeSectIndex + 4 > geometryLength)
                    return 0;
            memcpy(&numShapes, sourceBuff + shapeSectIndex, 4);
            shapeSectIndex += 4;
            if (shapeSectIndex + 9 * numShapes > geometryLength)
                    return 0;
            memcpy(&code, sourceBuff + shapeSectIndex + 8, 1);
            shapeSectIndex += 9;
            if (hasZ)
                    code += 1000;
            if (hasM)
                    code += 2000;
            if (code % 1000 == 2)
                    destBuffIndex += writeWKBLine(destBuff + destBuffIndex, code, sourceBuff, sBuffIndex, numPoints, 0, hasZ, hasM, numPoints, destCap);
            if (code % 1000 == 3)
                    destBuffIndex += writeWKBPoly(destBuff + destBuffIndex, code, sourceBuff, sBuffIndex, numPoints, numPoints, 0, figSectIndex, numFigures, hasZ, hasM, destCap);
            if (code % 1000 == 4)
                    destBuffIndex += writeWKBMPoint(destBuff + destBuffIndex, code, sourceBuff, sBuffIndex, numPoints, hasZ, hasM, destCap);
            if (code % 1000 == 5)
                    destBuffIndex += writeWKBMLine(destBuff + destBuffIndex, code, sourceBuff, sBuffIndex, numPoints, figSectIndex, numFigures, hasZ, hasM, destCap);
            if (code % 1000 == 6)
                    destBuffIndex += writeWKBMPoly(destBuff + destBuffIndex, code, sourceBuff, sBuffIndex, numPoints, figSectIndex, numFigures, shapeSectIndex, numShapes, hasZ, hasM, destCap);
            if (destCap < 0)
                    return 0;
    }
    assert(destBuffIndex <= outputLength);
    return destBuffIndex;


    
    //return geometryLength;
}