package com.elecnor.lighting.helper;

import java.util.List;

import com.elecnor.lighting.bean.FixtureDescription;
import com.elecnor.lighting.bean.FixtureManufacturer;
import com.elecnor.lighting.bean.FixtureVariant;
import com.elecnor.lighting.bean.LampCatalogNum;
import com.elecnor.lighting.bean.LampManufacturer;

public class MasterFixtureHelper {
	public static FixtureVariant getFixtureVariantById(String id,
			List<FixtureVariant> variantList) {
		int idInt = -1;
		try {
			idInt = Integer.parseInt(id);
		} catch (Exception e) {
			return null;
		}
		for (FixtureVariant fixVariant : variantList) {
			if (fixVariant.getVariantId() == idInt)
				return fixVariant;
		}
		return null;
	}

	public static FixtureDescription getFixtureDescriptionById(String id,
			List<FixtureDescription> fixDescList) {
		int idInt = -1;
		try {
			idInt = Integer.parseInt(id);
		} catch (Exception e) {
			return null;
		}
		for (FixtureDescription fixDesc : fixDescList) {
			if (fixDesc.getDescId() == idInt)
				return fixDesc;
		}
		return null;
	}

	public static FixtureManufacturer getFixtureManufacturerById(String id,
			List<FixtureManufacturer> fixManufList) {
		int idInt = -1;
		try {
			idInt = Integer.parseInt(id);
		} catch (Exception e) {
			return null;
		}
		for (FixtureManufacturer fixManuf : fixManufList) {
			if (fixManuf.getManufacturerId() == idInt)
				return fixManuf;
		}
		return null;
	}

	public static LampManufacturer getLampManufacturerDetailsById(String id,
			List<LampManufacturer> lampManufList) {
		int idInt = -1;
		try {
			idInt = Integer.parseInt(id);
		} catch (Exception e) {
			return null;
		}
		for (LampManufacturer lampManuf : lampManufList) {
			if (lampManuf.getManufacturerId() == idInt)
				return lampManuf;
		}
		return null;
	}

	public static LampCatalogNum getLampCatalogNoDetailsById(String id,
			List<LampCatalogNum> lampCatalogNoList) {
		int idInt = -1;
		try {
			idInt = Integer.parseInt(id);
		} catch (Exception e) {
			return null;
		}
		for (LampCatalogNum lampCatalog : lampCatalogNoList) {
			if (lampCatalog.getCatalogId() == idInt)
				return lampCatalog;
		}
		return null;
	}
}
