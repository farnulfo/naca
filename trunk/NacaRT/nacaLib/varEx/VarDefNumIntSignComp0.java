/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs v1.2.0.
 *
 * Copyright (c) 2005, 2006, 2007, 2008, 2009 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/*
 * Created on 20 mars 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package nacaLib.varEx;

import java.math.BigDecimal;

import jlib.misc.*;
import nacaLib.bdb.BtreeSegmentKeyTypeFactory;
import nacaLib.debug.BufferSpy;
import nacaLib.mathSupport.MathAdd;
import nacaLib.sqlSupport.CSQLItemType;
import nacaLib.tempCache.CStr;
import nacaLib.tempCache.CStrNumber;
import nacaLib.tempCache.TempCacheLocator;

/**
 * @author U930DI
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class VarDefNumIntSignComp0 extends VarDefNum
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VarDefNumIntSignComp0(VarDefBase varDefParent, DeclareType9 declareType9, NumericValue numericValue)
	{
		super(varDefParent, declareType9.m_varLevel);
		m_nNbDigitInteger = numericValue.m_nNbDigitInteger;
	}
	
	protected VarDefNumIntSignComp0()
	{
		super();
	}
	
//	VarDefNumIntSignComp0(VarDefNumIntSignComp0 varDefSource)
//	{
//		super(varDefSource);
//		m_nNbDigitInteger = varDefSource.m_nNbDigitInteger;
//	}
//	
//	VarDefBuffer deepDuplicate()
//	{
//		return new VarDefNumIntSignComp0(this);
//	}
	
	void transfer(VarBufferPos bufferSource, VarAndEdit Dest)
	{
		Dest.m_varDef.write(Dest.m_bufferPos, this, bufferSource);	// PJD Var TO EditInMapRedefine; // PJD Var TO EditInMap 
	}
	
	CSQLItemType getSQLType()
	{
		return getIntegerSQLType(m_nNbDigitInteger);
	}
	
	protected VarDefBuffer allocCopy()
	{
		VarDefNumIntSignComp0 v = new VarDefNumIntSignComp0();
		v.m_nNbDigitInteger = m_nNbDigitInteger;
		return v;
	}
	
	public int getBodyLength()
	{
		return m_nTotalSize;
	}
	
	protected int getHeaderLength()
	{
		return 0;
	}

	
	public int getSingleItemRequiredStorageSize()
	{
		return m_nNbDigitInteger;
	}
	
	CStr getAsDecodedString(VarBufferPos buffer)
	{
		//String cs = getRawStringExcludingHeader(buffer);
		CStr cs = buffer.getBodyCStr(this);
		return cs;
	}
	
	int getAsDecodedInt(VarBufferPos buffer)
	{
		int n = internalReadSignedIntComp0(buffer, buffer.m_nAbsolutePosition, m_nTotalSize);
		return n;
	}
	
	int getAsDecodedUnsignedInt(VarBufferPos buffer)
	{
		int n = internalReadUnsignedIntComp0(buffer, buffer.m_nAbsolutePosition, m_nTotalSize);
		return n;
	}
	
	long getAsDecodedLong(VarBufferPos buffer)
	{
		long l = internalReadSignedIntComp0AsLong(buffer, buffer.m_nAbsolutePosition, m_nTotalSize);
		return l;
	}
	
	
	Dec getAsDecodedDec(VarBufferPos buffer)
	{
		long lInt = internalReadSignedIntComp0AsLong(buffer, buffer.m_nAbsolutePosition, m_nTotalSize);
		Dec dec = new Dec(lInt, "");
		return dec;
	}
	
	CStr getAsAlphaNumString(VarBufferPos buffer)
	{
		CStr cs = internalReadSignedIntComp0AsUnsignedString(buffer, buffer.m_nAbsolutePosition, m_nTotalSize);
		return cs;
	}	
	
	CStr getDottedSignedString(VarBufferPos buffer)
	{	
		int n = internalReadSignedIntComp0(buffer, buffer.m_nAbsolutePosition, m_nTotalSize);
		CStrNumber cs = TempCacheLocator.getTLSTempCache().getCStrNumber();
		cs.valueOf(n);		
		return cs;
	}
	
	CStr getDottedSignedStringAsSQLCol(VarBufferPos buffer)
	{
		int n = internalReadSignedIntComp0(buffer, buffer.m_nAbsolutePosition, m_nTotalSize);
		CStrNumber cs = TempCacheLocator.getTLSTempCache().getCStrNumber();
		cs.valueOf(n);		
		return cs;
	}
	
	void write(VarBufferPos buffer, char c)
	{
		int n = NumberParser.getAsUnsignedInt(c);
		writeSignedIntComp0(buffer, n);
	}
	
	public void write(VarBufferPos buffer, String cs)
	{
		long l = NumberParser.getAsLong(cs);
		writeSignedIntComp0AsLong(buffer, l);
	}
	
	public void inc(VarBufferPos buffer, int n)
	{
		int nVal = getAsDecodedInt(buffer);
		nVal += n;
		write(buffer, nVal);
	}

	public void inc(VarBufferPos buffer, BigDecimal bdStep)
	{
		CStr s1 = getDottedSignedString(buffer);
		Dec dec = MathAdd.inc(s1, bdStep);
		write(buffer, dec);
	}
		
	public void write(VarBufferPos buffer, int n)
	{
		writeSignedIntComp0(buffer, n);
	}
	
	public void write(VarBufferPos buffer, long l)
	{
		writeSignedIntComp0(buffer, (int)l);
	}

	
	void write(VarBufferPos buffer, double d)
	{
		int n = (int) d;
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, Dec dec)
	{
		writeSignedIntComp0(buffer, dec.getSignedInt());
	}
	
	public void write(VarBufferPos buffer, BigDecimal bigDecimal)
	{
		long lValue = bigDecimal.longValue();
		writeSignedIntComp0AsLong(buffer, lValue);
	}
	
	void write(VarBufferPos buffer, VarDefG varSource, VarBufferPos bufferSource)
	{
		// http://h71000.www7.hp.com/DOC/73final/6297/6297_profile_010.html#alpha_elem_move_sec
		// If the sending item is a group item, and the receiving item is an elementary item, the compiler ignores the receiving item description except for the size description, in bytes, and any JUSTIFIED clause. It conducts no conversion or editing on the sending item's data
		internalPhysicalWrite(buffer, varSource, bufferSource); 
	}

	void write(VarBufferPos buffer, VarDefX varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getUnsignedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefFPacAlphaNum varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getUnsignedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefFPacRaw varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getUnsignedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumDecComp0 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumDecComp3 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}

	void write(VarBufferPos buffer, VarDefNumDecComp4 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumDecSignComp4 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumDecSignComp0 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumDecSignComp3 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumDecSignLeadingComp0 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumDecSignTrailingComp0 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumIntComp0 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumIntComp0Long varSource, VarBufferPos bufferSource)
	{
		long l = varSource.getAsDecodedLong(bufferSource);
		writeSignedIntComp0AsLong(buffer, l);
	}
	
	void write(VarBufferPos buffer, VarDefNumIntComp3 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumIntComp3Long varSource, VarBufferPos bufferSource)
	{
		long l = varSource.getAsDecodedLong(bufferSource);
		writeSignedIntComp0AsLong(buffer, l);
	}

	
	void write(VarBufferPos buffer, VarDefNumIntComp4 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumIntComp4Long varSource, VarBufferPos bufferSource)
	{
		long l = varSource.getAsDecodedLong(bufferSource);
		writeSignedIntComp0AsLong(buffer, l);
	}
	
	public void moveIntoSameType(VarBufferPos buffer, VarDefBuffer varSource, VarBufferPos bufferSource)
	{
		if(m_nTotalSize == varSource.m_nTotalSize)	// Same type and same size: Directly copy bytes
		{
			int nPositionDest = buffer.m_nAbsolutePosition;
			int nPositionSource = bufferSource.m_nAbsolutePosition;
			if(BufferSpy.BUFFER_WRITE_DEBUG) BufferSpy.prewrite(buffer.m_acBuffer, nPositionDest, m_nTotalSize);
			for(int n=0; n<m_nTotalSize; n++)
			{
				buffer.m_acBuffer[nPositionDest++] = bufferSource.m_acBuffer[nPositionSource++];
			}	
			if(BufferSpy.BUFFER_WRITE_DEBUG) BufferSpy.endwrite();
			return ;
		}

		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumIntSignComp0 varSource, VarBufferPos bufferSource)
	{
		if(m_nTotalSize == varSource.m_nTotalSize)	// Same type and same size: Directly copy bytes
		{
			int nPositionDest = buffer.m_nAbsolutePosition;
			int nPositionSource = bufferSource.m_nAbsolutePosition;
			if(BufferSpy.BUFFER_WRITE_DEBUG) BufferSpy.prewrite(buffer.m_acBuffer, nPositionDest, m_nTotalSize);
			for(int n=0; n<m_nTotalSize; n++)
			{
				buffer.m_acBuffer[nPositionDest++] = bufferSource.m_acBuffer[nPositionSource++];
			}			
			if(BufferSpy.BUFFER_WRITE_DEBUG) BufferSpy.endwrite();
			return ;
		}

		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}

	void write(VarBufferPos buffer, VarDefNumIntSignComp0Long varSource, VarBufferPos bufferSource)
	{
		long l = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0AsLong(buffer, l);
	}

	void write(VarBufferPos buffer, VarDefNumIntSignComp3 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefFPacNumIntSignComp3 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumIntSignComp3Long varSource, VarBufferPos bufferSource)
	{
		long l = varSource.getAsDecodedLong(bufferSource);
		writeSignedIntComp0AsLong(buffer, l);
	}
	
	void write(VarBufferPos buffer, VarDefNumIntSignComp4 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumIntSignComp4Long varSource, VarBufferPos bufferSource)
	{
		long l = varSource.getAsDecodedLong(bufferSource);
		writeSignedIntComp0AsLong(buffer, l);
	}
	
	void write(VarBufferPos buffer, VarDefNumIntSignLeadingComp0 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumIntSignLeadingComp0Long varSource, VarBufferPos bufferSource)
	{
		long l = varSource.getAsDecodedLong(bufferSource);
		writeSignedIntComp0AsLong(buffer, l);
	}
	
	void write(VarBufferPos buffer, VarDefNumIntSignTrailingComp0 varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefNumIntSignTrailingComp0Long varSource, VarBufferPos bufferSource)
	{
		long l = varSource.getAsDecodedLong(bufferSource);
		writeSignedIntComp0AsLong(buffer, l);
	}
	
	void write(VarBufferPos buffer, VarDefEditInMap varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);	// PJD Var TO Edit
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefEditInMapRedefine varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}	
	
	void write(VarBufferPos buffer, VarDefEditInMapRedefineNumEdited varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	void write(VarBufferPos buffer, VarDefEditInMapRedefineNum varSource, VarBufferPos bufferSource)
	{
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}



	
	void write(VarBufferPos buffer, VarDefNumEdited varSource, VarBufferPos bufferSource)
	{
		// see http://www.helsinki.fi/atk/unix/dec_manuals/cobv27ua/cobrm_029.htm#index_x_737
		int n = varSource.getAsDecodedInt(bufferSource);
		writeSignedIntComp0(buffer, n);
	}
	
	

	
	void write(VarBufferPos buffer, CobolConstantZero cst)
	{
		writeSignedIntComp0(buffer, 0);
	}

	void write(VarBufferPos buffer, CobolConstantSpace cst)
	{
		// Do nothing into numeric vars
	}

	void write(VarBufferPos buffer, CobolConstantLowValue cst)
	{
		// Do nothing into numeric vars
	}

	void write(VarBufferPos buffer, CobolConstantHighValue cst)
	{
		// Do nothing into numeric vars
	}
	
	void write(VarBufferPos buffer, CobolConstantZero cst, int nOffsetPosition, int nNbChar)
	{
		writeRepeatingCharUpToEnd(buffer, cst.getValue(), nOffsetPosition, nNbChar);
	}

	void write(VarBufferPos buffer, CobolConstantSpace cst, int nOffsetPosition, int nNbChar)
	{
		writeRepeatingCharUpToEnd(buffer, cst.getValue(), nOffsetPosition, nNbChar);
	}
	
	void write(VarBufferPos buffer, CobolConstantLowValue cst, int nOffsetPosition, int nNbChar)
	{
		writeRepeatingCharUpToEnd(buffer, cst.getValue(), nOffsetPosition, nNbChar);
	}
	
	void write(VarBufferPos buffer, CobolConstantHighValue cst, int nOffsetPosition, int nNbChar)
	{
		writeRepeatingCharUpToEnd(buffer, cst.getValue(), nOffsetPosition, nNbChar);
	}
	
	void write(VarBufferPos buffer, String csValue, int nOffsetPosition, int nNbChar)
	{		
		internalWriteSubstringComp0(buffer, csValue, nOffsetPosition, nNbChar);
	}
	
	
//	public void initialize(VarBufferPos buffer)
//	{
//		writeSignedIntComp0(buffer, 0);
//	}

	public void initializeAtOffset(VarBufferPos buffer, int nOffset, InitializeCache initializeCache)
	{
		writeSignedIntComp0(buffer, nOffset, 0);
		if(initializeCache != null)
			initializeCache.addItem(buffer, nOffset, getSingleItemRequiredStorageSize());
	}

//	void initialize(VarBufferPos buffer, String cs)
//	{
//	}

	void initializeAtOffset(VarBufferPos buffer, int nOffset, String cs)
	{		
	}

//	void initialize(VarBufferPos buffer, int n)
//	{
//		writeSignedIntComp0(buffer, n);
//	}
	
	void initializeAtOffset(VarBufferPos buffer, int nOffset, int n)
	{
		writeSignedIntComp0(buffer, nOffset, n);
	}
	
	void initializeEdited(VarBufferPos buffer, String cs)
	{
	}
	
	void initializeEdited(VarBufferPos buffer, int n)
	{
	}
	
	void initializeEditedAtOffset(VarBufferPos buffer, int nOffset, int nValue)
	{
	}
	
	void initializeEditedAtOffset(VarBufferPos buffer, int nOffset, double dValue)
	{
	}
	
	private void writeSignedIntComp0(VarBufferPos buffer, int nValue)
	{
//		int nPos = RWNumIntComp0.internalWriteAbsoluteIntComp0(buffer, nValue, buffer.m_nAbsolutePosition, m_nTotalSize);
//
//		boolean bPositive = true;
//		if(nValue < 0)
//			bPositive = false;
//		internalWriteEmbeddedComp0Sign(buffer, bPositive);
//		
//		return nPos;
		
		Pic9Comp0BufferSupport.setFromRightToLeftSignEmbedded(buffer, buffer.m_nAbsolutePosition, m_nTotalSize, m_nTotalSize, 0, nValue);
	}
	
	private int writeSignedIntComp0(VarBufferPos buffer, int nOffset, int nValue)
	{
		int nPos = RWNumIntComp0.internalWriteAbsoluteIntComp0(buffer, nOffset, nValue, buffer.m_nAbsolutePosition, m_nTotalSize);

		boolean bPositive = true;
		if(nValue < 0)
			bPositive = false;
		internalWriteEmbeddedComp0Sign(buffer, nOffset, bPositive);
		
		return nPos;
	}

	
	private int writeSignedIntComp0AsLong(VarBufferPos buffer, long lValue)
	{
		int nPos = RWNumIntComp0.internalWriteAbsoluteIntComp0AsLong(buffer, lValue, buffer.m_nAbsolutePosition, m_nTotalSize);

		boolean bPositive = true;
		if(lValue < 0)
			bPositive = false;
		internalWriteEmbeddedComp0Sign(buffer, bPositive);
		
		return nPos;
	}
	
	
	int compare(ComparisonMode mode, VarBufferPos bufferSource, VarAndEdit var2)
	{
		return var2.m_varDef.compare(mode, var2.m_bufferPos, this, bufferSource);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumDecComp0 varDefNum1, VarBufferPos buffer1)
	{
		Dec dec1 = varDefNum1.getAsDecodedDec(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(dec1, n2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumDecComp3 varDefNum1, VarBufferPos buffer1)
	{
		Dec dec1 = varDefNum1.getAsDecodedDec(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(dec1, n2);
	}

	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumDecComp4 varDefNum1, VarBufferPos buffer1)
	{
		Dec dec1 = varDefNum1.getAsDecodedDec(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(dec1, n2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumDecSignComp4 varDefNum1, VarBufferPos buffer1)
	{
		Dec dec1 = varDefNum1.getAsDecodedDec(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(dec1, n2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumDecSignComp0 varDefNum1, VarBufferPos buffer1)
	{
		Dec dec1 = varDefNum1.getAsDecodedDec(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(dec1, n2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumDecSignComp3 varDefNum1, VarBufferPos buffer1)
	{
		Dec dec1 = varDefNum1.getAsDecodedDec(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(dec1, n2);
	}

	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumDecSignLeadingComp0 varDefNum1, VarBufferPos buffer1)
	{
		Dec dec1 = varDefNum1.getAsDecodedDec(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(dec1, n2);
	}

	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumDecSignTrailingComp0 varDefNum1, VarBufferPos buffer1)
	{
		Dec dec1 = varDefNum1.getAsDecodedDec(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(dec1, n2);
	}

	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntComp0 varDefNum1, VarBufferPos buffer1)
	{
		int n1 = varDefNum1.getAsDecodedInt(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(n1, n2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntComp0Long varDefNum1, VarBufferPos buffer1)
	{
		long l1 = varDefNum1.getAsDecodedLong(buffer1);
		long l2 = getAsDecodedLong(buffer2);
		return internalCompare(l1, l2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntComp3 varDefNum1, VarBufferPos buffer1)
	{
		int n1 = varDefNum1.getAsDecodedInt(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(n1, n2);
	}

	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntComp3Long varDefNum1, VarBufferPos buffer1)
	{
		long l1 = varDefNum1.getAsDecodedLong(buffer1);
		long l2 = getAsDecodedLong(buffer2);
		return internalCompare(l1, l2);
	}


	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntComp4 varDefNum1, VarBufferPos buffer1)
	{
		int n1 = varDefNum1.getAsDecodedInt(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(n1, n2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntComp4Long varDefNum1, VarBufferPos buffer1)
	{
		long l1 = varDefNum1.getAsDecodedLong(buffer1);
		long l2 = getAsDecodedLong(buffer2);
		return internalCompare(l1, l2);
	}

	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntSignComp0 varDefNum1, VarBufferPos buffer1)
	{
		int n1 = varDefNum1.getAsDecodedInt(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(n1, n2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntSignComp0Long varDefNum1, VarBufferPos buffer1)
	{
		long l1 = varDefNum1.getAsDecodedLong(buffer1);
		long l2 = getAsDecodedLong(buffer2);
		return internalCompare(l1, l2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntSignComp3 varDefNum1, VarBufferPos buffer1)
	{
		int n1 = varDefNum1.getAsDecodedInt(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(n1, n2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefFPacNumIntSignComp3 varDefNum1, VarBufferPos buffer1)
	{
		int n1 = varDefNum1.getAsDecodedInt(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(n1, n2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntSignComp3Long varDefNum1, VarBufferPos buffer1)
	{
		long l1 = varDefNum1.getAsDecodedLong(buffer1);
		long l2 = getAsDecodedLong(buffer2);
		return internalCompare(l1, l2);
	}

	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntSignComp4 varDefNum1, VarBufferPos buffer1)
	{
		int n1 = varDefNum1.getAsDecodedInt(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(n1, n2);
	}	
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntSignComp4Long varDefNum1, VarBufferPos buffer1)
	{
		long l1 = varDefNum1.getAsDecodedInt(buffer1);
		long l2 = getAsDecodedInt(buffer2);
		return internalCompare(l1, l2);
	}	

	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntSignLeadingComp0 varDefNum1, VarBufferPos buffer1)
	{
		int n1 = varDefNum1.getAsDecodedInt(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(n1, n2);
	}	
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntSignLeadingComp0Long varDefNum1, VarBufferPos buffer1)
	{
		long l1 = varDefNum1.getAsDecodedInt(buffer1);
		long l2 = getAsDecodedInt(buffer2);
		return internalCompare(l1, l2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntSignTrailingComp0 varDefNum1, VarBufferPos buffer1)
	{
		int n1 = varDefNum1.getAsDecodedInt(buffer1);
		int n2 = getAsDecodedInt(buffer2);
		return internalCompare(n1, n2);
	}	
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumIntSignTrailingComp0Long varDefNum1, VarBufferPos buffer1)
	{
		long l1 = varDefNum1.getAsDecodedInt(buffer1);
		long l2 = getAsDecodedInt(buffer2);
		return internalCompare(l1, l2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefX varDef1, VarBufferPos buffer1)
	{
		// see http://publibz.boulder.ibm.com/cgi-bin/bookmgr_OS390/BOOKS/IGYLR205/6.1.6.5.3?SHELF=&DT=20000927030801&CASE=
		// see http://h71000.www7.hp.com/DOC/73final/6297/6297_profile_010.html#group_items_sec
		// If the nonnumeric operand is an elementary item or a literal, the compiler treats the numeric operand as if it had been moved into an alphanumeric data item the same size as the numeric operand and then compared. This causes any operational sign, whether carried as a separate character or as an overpunched character, to be stripped from the numeric item so that it appears to be an unsigned quantity. 
		// In addition, if the PICTURE character-string of the numeric item contains trailing P characters, indicating that there are assumed integer positions that are not actually present, they are filled with zero digits. Thus, an item with a PICTURE character-string of S9999PPP is moved to a temporary location where it is described as 9999999. If its value is 432J (--4321), the value in the temporary location will be 4321000. The numeric digits take part in the comparison.
		//String cs1 = varDef1.getRawStringExcludingHeader(buffer1);
		CStr cs1 = buffer1.getBodyCStr(varDef1);		
//		int n2 = getUnsignedInt(buffer2);
//		String cs2 = getStringRightPadded(n2, ' ', getTotalSize());
		CStr cs2 = getAsAlphaNumString(buffer2);
		return internalCompare(mode, cs1, cs2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefFPacAlphaNum varDef1, VarBufferPos buffer1)
	{
		// see http://publibz.boulder.ibm.com/cgi-bin/bookmgr_OS390/BOOKS/IGYLR205/6.1.6.5.3?SHELF=&DT=20000927030801&CASE=
		// see http://h71000.www7.hp.com/DOC/73final/6297/6297_profile_010.html#group_items_sec
		// If the nonnumeric operand is an elementary item or a literal, the compiler treats the numeric operand as if it had been moved into an alphanumeric data item the same size as the numeric operand and then compared. This causes any operational sign, whether carried as a separate character or as an overpunched character, to be stripped from the numeric item so that it appears to be an unsigned quantity. 
		// In addition, if the PICTURE character-string of the numeric item contains trailing P characters, indicating that there are assumed integer positions that are not actually present, they are filled with zero digits. Thus, an item with a PICTURE character-string of S9999PPP is moved to a temporary location where it is described as 9999999. If its value is 432J (--4321), the value in the temporary location will be 4321000. The numeric digits take part in the comparison.
		//String cs1 = varDef1.getRawStringExcludingHeader(buffer1);
		CStr cs1 = buffer1.getBodyCStr(varDef1);
//		int n2 = getUnsignedInt(buffer2);
//		String cs2 = getStringRightPadded(n2, ' ', getTotalSize());
		CStr cs2 = getAsAlphaNumString(buffer2);
		return internalCompare(mode, cs1, cs2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefFPacRaw varDef1, VarBufferPos buffer1)
	{
		// see http://publibz.boulder.ibm.com/cgi-bin/bookmgr_OS390/BOOKS/IGYLR205/6.1.6.5.3?SHELF=&DT=20000927030801&CASE=
		// see http://h71000.www7.hp.com/DOC/73final/6297/6297_profile_010.html#group_items_sec
		// If the nonnumeric operand is an elementary item or a literal, the compiler treats the numeric operand as if it had been moved into an alphanumeric data item the same size as the numeric operand and then compared. This causes any operational sign, whether carried as a separate character or as an overpunched character, to be stripped from the numeric item so that it appears to be an unsigned quantity. 
		// In addition, if the PICTURE character-string of the numeric item contains trailing P characters, indicating that there are assumed integer positions that are not actually present, they are filled with zero digits. Thus, an item with a PICTURE character-string of S9999PPP is moved to a temporary location where it is described as 9999999. If its value is 432J (--4321), the value in the temporary location will be 4321000. The numeric digits take part in the comparison.
		//String cs1 = varDef1.getRawStringExcludingHeader(buffer1);
		CStr cs1 = buffer1.getBodyCStr(varDef1);
//		int n2 = getUnsignedInt(buffer2);
//		String cs2 = getStringRightPadded(n2, ' ', getTotalSize());
		CStr cs2 = getAsAlphaNumString(buffer2);
		return internalCompare(mode, cs1, cs2);
	}
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefG varDef1, VarBufferPos buffer1)
	{
		// see http://publibz.boulder.ibm.com/cgi-bin/bookmgr_OS390/BOOKS/IGYLR205/6.1.6.5.3?SHELF=&DT=20000927030801&CASE=
		// see http://h71000.www7.hp.com/DOC/73final/6297/6297_profile_010.html#group_items_sec
		// If the nonnumeric operand is a group item, the compiler treats the numeric operand as if it had been moved into a group item the same size as the numeric operand and then compared. This is equivalent to a group move. 
		// The compiler ignores the description of the numeric item (except for length) and, therefore, includes in its length any operational sign, whether carried as a separate character or as an overpunched character. Overpunched characters are never ASCII numeric digits. They are characters ranging from A to R, left brace ({), or right brace (}). Thus, the sign and the digits, stored as ASCII bytes, take part in the comparison, and zeros are not supplied for P characters in the PICTURE character-string. 
		//String cs1 = varDef1.getRawStringExcludingHeader(buffer1);
		CStr cs1 = buffer1.getBodyCStr(varDef1);
//		int n2 = getInt(buffer2);
//		String cs2 = getStringRightPadded(n2, ' ', varDef1.getTotalSize());
		CStr cs2 = getAsAlphaNumString(buffer2);
		return internalCompare(mode, cs1, cs2);
	}	
	
	int compare(ComparisonMode mode, VarBufferPos buffer2, VarDefNumEdited varDef1, VarBufferPos buffer1)
	{
		assertIfFalse(false);
		// TODO how to compare with num edited ?
		return 0;
	}
	
	public String digits(VarBufferPos buffer)
	{
		return getAsAlphaNumString(buffer).getAsString();
	}

	public int getNbDigitDecimal()
	{
		return 0;
	}
	
	boolean isConvertibleInEbcdic()
	{
		return true;
	}	
	
	public int getTypeId()
	{
		return VarTypeId.VarDefNumIntSignComp0TypeId;
	}

	public boolean isEbcdicAsciiConvertible()
	{
		return true;
	}
	
	public int getTrailingLengthToNotconvert()
	{
		return 1;	// Do not convert last char
	}
	
	public BtreeSegmentKeyTypeFactory getSegmentKeyTypeFactory()
	{
		return VarTypeId.m_segmentKeyTypeFactoryComp0;
	}
	
	protected void adjustCustomProperty(VarDefBuffer varDefBufferCopySingleItem)
	{
		VarDefNumIntSignComp0 varDefCopy = (VarDefNumIntSignComp0)varDefBufferCopySingleItem;
		varDefCopy.m_nNbDigitInteger = m_nNbDigitInteger;
	}
	
	protected void adjustCustomPropertyForCharGetAt(VarDefBuffer varDefBufferCopySingleItem)
	{
		VarDefNumIntSignComp0 varDefCopy = (VarDefNumIntSignComp0)varDefBufferCopySingleItem;
		varDefCopy.m_nNbDigitInteger = 1;
	}
	
	boolean isNumeric(VarBufferPos buffer)
	{
		CStr cs = buffer.getBodyCStr(this);
		return cs.isOnlyNumericComp0(true, false);
	}
	
	private int m_nNbDigitInteger;
}
