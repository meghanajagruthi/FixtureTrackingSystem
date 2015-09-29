package com.elecnor.lighting.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elecnor.lighting.bean.FixtureDescription;
import com.elecnor.lighting.bean.FixtureManufacturer;
import com.elecnor.lighting.bean.FixtureVariant;
import com.elecnor.lighting.bean.LampCatalogNum;
import com.elecnor.lighting.bean.LampManufacturer;
import com.elecnor.lighting.service.MasterFixtureService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class MasterFixtureController {

	@RequestMapping("/masterFixture")
	public String getMasterFixture() {
		return "masterFixture";
	}

	@Autowired
	MasterFixtureService masterFixtureService;

	// Add Fixture Variant
	@RequestMapping(value = "fixtureVariantAction", method = RequestMethod.POST)
	@ResponseBody
	public String addFixtureVariant(
			@RequestParam("fixVariantType") String fixVariantType) {
		masterFixtureService.addFixtureVariant(fixVariantType);
		HashMap<String, String> mapVar = new HashMap<String, String>();
		mapVar.put("fixtureVariantStatus", "");
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(mapVar);
		return json;
	}

	// Get Fixture Variant List
	@RequestMapping(value = "/getfixVariantDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getFixtureVariant() {

		List<FixtureVariant> fixVarList = (List<FixtureVariant>) masterFixtureService
				.getFixtureVariant();
		HashMap<String, List<FixtureVariant>> mapVar = new HashMap<String, List<FixtureVariant>>();
		mapVar.put("aaData", fixVarList);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(mapVar);
		return json;
	}

	@RequestMapping(value = "fixtureDescAction", method = RequestMethod.POST)
	@ResponseBody
	public String addFixtureDescription(@RequestParam("fixDesc") String fixDesc) {

		masterFixtureService.addFixtureDescription(fixDesc);
		HashMap<String, String> mapDesc = new HashMap<String, String>();
		mapDesc.put("fixtureDescriptionStatus", "");
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(mapDesc);
		return json;
	}

	@RequestMapping(value = "/getfixDescriptionDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getFixtureDescription() {
		List<FixtureDescription> fixDescList = masterFixtureService
				.getFixtureDescription();
		HashMap<String, List<FixtureDescription>> map = new HashMap<String, List<FixtureDescription>>();
		map.put("aaData1", fixDescList);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@RequestMapping(value = "fixManufacturerAction", method = RequestMethod.POST)
	@ResponseBody
	public String addFixtureManufacturer(
			@RequestParam("fixManufacturer") String fixManufacturer) {
		masterFixtureService.addFixtureManufacturer(fixManufacturer);
		HashMap<String, String> mapManf = new HashMap<String, String>();
		mapManf.put("fixtureManusacturerStatus", "");
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(mapManf);
		return json;
	}

	@RequestMapping(value = "/getfixManufacturerDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getFixtureManufacturer() {
		List<FixtureManufacturer> fixManfList = masterFixtureService
				.getFixtureManufacturer();
		HashMap<String, List<FixtureManufacturer>> map = new HashMap<String, List<FixtureManufacturer>>();
		map.put("aaData", fixManfList);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@RequestMapping(value = "lampManufactAction", method = RequestMethod.POST)
	@ResponseBody
	public String addLampManufacturer(
			@RequestParam("lampManufacturer") String lampManufacturer) {
		masterFixtureService.addLampManufacturer(lampManufacturer);
		HashMap<String, String> mapManfLamp = new HashMap<String, String>();
		mapManfLamp.put("lampManusacturerStatus", "");
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(mapManfLamp);
		return json;
	}

	@RequestMapping(value = "/getlampManufacturerDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getLampManufacturerDetails() {
		List<LampManufacturer> lampManfList = masterFixtureService
				.getLampManufacturerDetails();
		HashMap<String, List<LampManufacturer>> map = new HashMap<String, List<LampManufacturer>>();
		map.put("aaData", lampManfList);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@RequestMapping(value = "lampCatalogAction", method = RequestMethod.POST)
	@ResponseBody
	public String addLampCatalogNo(
			@RequestParam("lampCatalog") String lampCatalog) {
		masterFixtureService.addLampCatalogNo(lampCatalog);
		HashMap<String, String> mapCatalogLamp = new HashMap<String, String>();
		mapCatalogLamp.put("lampCatalogStatus", "");
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(mapCatalogLamp);
		return json;
	}

	@RequestMapping(value = "/getlampCatalogNoDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getLampCatalogNoDetails() {
		List<LampCatalogNum> lampCatList = masterFixtureService
				.getLampCatalogNoDetails();
		HashMap<String, List<LampCatalogNum>> map = new HashMap<String, List<LampCatalogNum>>();
		map.put("aaData", lampCatList);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}
}
