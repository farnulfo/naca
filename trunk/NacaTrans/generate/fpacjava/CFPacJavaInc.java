/*
 * NacaTrans - Naca Transcoder v1.2.0.
 *
 * Copyright (c) 2008-2009 Publicitas SA.
 * Licensed under GPL (GPL-LICENSE.txt) license.
 */
/*
 * NacaRTTests - Naca Tests for NacaRT support.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under GPL (GPL-LICENSE.txt) license.
 */
package generate.fpacjava;

import generate.CBaseLanguageExporter;
import semantic.CDataEntity.CDataEntityType;
import semantic.Verbs.CEntityInc;
import utils.CObjectCatalog;

/**
 * @author S. Charton
 * @version $Id$
 */
public class CFPacJavaInc extends CEntityInc
{

	/**
	 * @param line
	 * @param cat
	 * @param out
	 */
	public CFPacJavaInc(int line, CObjectCatalog cat, CBaseLanguageExporter out)
	{
		super(line, cat, out);
	}

	/**
	 * @see semantic.CBaseLanguageEntity#DoExport()
	 */
	@Override
	protected void DoExport()
	{
		String line = "" ;

		line += m_AddDest.ExportReference(getLine()) ;

		if (m_AddValue.GetDataType() == CDataEntityType.NUMBER && m_AddValue.GetConstantValue().equals("1"))
		{
			line += "++ ;" ;
		}
		else if (m_AddValue.GetDataType() == CDataEntityType.NUMBER && m_AddValue.GetConstantValue().equals("-1"))
		{
			line += "-- ;" ;
		}
		else
		{
			line += "+= " + m_AddValue.ExportReference(getLine()) + " ;" ;
		}
		WriteLine(line) ;
	}

}
