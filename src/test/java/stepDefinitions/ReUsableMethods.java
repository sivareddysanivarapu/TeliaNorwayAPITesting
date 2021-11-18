package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReUsableMethods{

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
		String datetime = ft.format(dNow);
		return datetime;
	}
	
	public static String getOrderID() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String datetime = ft.format(dNow);
		return datetime;
	}
	
	public static RequestSpecification OAMHeader() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
		return new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
				.addHeader("X-OAUTH-IDENTITY-DOMAIN-NAME","APIDomain")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
	}
	
	public static RequestSpecification givenHeader() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
		return new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
				.addHeader("orderId", getOrderID())
				//.addHeader("X-OAUTH-IDENTITY-DOMAIN-NAME","APIDomain")
				//.addHeader("access_token", stepDefinition.accessToken)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
	}
	
	public static RequestSpecification modifyHeader() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
		return new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
				.addHeader("X-OAUTH-IDENTITY-DOMAIN-NAME","APIDomain")
				.addHeader("access_token", stepDefinition.accessToken)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
	}
	
	public static RequestSpecification onlyHeader() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
		return new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
				.addHeader("X-OAUTH-IDENTITY-DOMAIN-NAME","APIDomain")
				.addHeader("access_token", stepDefinition.accessToken)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
	}
	
	public static RequestSpecification getHeader() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
		return new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
				.addHeader("X-OAUTH-IDENTITY-DOMAIN-NAME","APIDomain")
				.addHeader("access_token", stepDefinition.accessToken)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
	}
	
	public static ResponseSpecification successResponse() {
		return new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}
	
	public static ResponseSpecification postResponse() {
		return new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
	}
	
	public static ResponseSpecification deleteResponse() {
		return new ResponseSpecBuilder().expectStatusCode(204).expectContentType(ContentType.TEXT).build();
	}

	public static ResponseSpecification failureResponse() {
		return new ResponseSpecBuilder().expectStatusCode(400).expectContentType(ContentType.JSON).build();
	}
	
	public static ResponseSpecification existingResponse() {
		return new ResponseSpecBuilder().expectStatusCode(409).expectContentType(ContentType.JSON).build();
	}

	public static ResponseSpecification serverResponse() {
		return new ResponseSpecBuilder().expectStatusCode(500).expectContentType(ContentType.JSON).build();
	}
	
	public static ResponseSpecification notFoundResponse() {
		return new ResponseSpecBuilder().expectStatusCode(404).expectContentType(ContentType.JSON).build();
	}
	
	public static ResponseSpecification bundleResponse() {
		return new ResponseSpecBuilder().expectStatusCode(422).expectContentType(ContentType.JSON).build();
	}
	
	public static String getGlobalValues(String key) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\ashok.surasani\\eclipse-workspace\\teliaAPIAutomation\\teliaNorwayAPITesting\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	public static String getAPI(String key) {
		
		String api = "/api/v1";
		switch(key) {
		case "OAM":
			key = api + "/accessToken";
			break;
		case "Subscription":
			key = api + "/subscriptions/";
			break;
		case "Bundle":
			key = "/bundles/";
			break;
		case "RCCBundle":
			key = "/bundles/rcc/";
			break;
		case "Topup":
			key = "/topups";
			break;
		case "ServiceIdentifier":
			key = "/serviceIdentifier";
			break;
		case "Provision":
			key = api + "/provision";
			break;
		case "Balances":
			key = "/balances";
			break;
		default:
			key = "/api/v1/subscriptions/serviceIdentifier";
		}
		return key;
	}
	
	public static String getResponseStatus(String key) {
		switch(key) {
		case "post":
			key = "201";
			break;
		case "get":
		case "put":
		case "patch":
			key = "200";
			break;
		case "delete":
			key = "204";
			break;
		case "notFound":
			key = "404";
			break;
		case "failure":
			key = "400";
			break;
		case "existing":
			key = "409";
			break;
		case "server":
			key = "500";
			break;
		default:
			key = "422";
		}
		return key;
	}
	
	//Bearer Token
	protected static String bearerToken = "eyJraWQiOiJBUElEb21haW4iLCJ4NXQiOiJvQmY0WDdIdjRVblg4dzA0NWdTMWZMaUtRTUEiLCJhbGciOiJSUzI1NiJ9.eyJleHAiOjE2MzcyNTk1MTUsImp0aSI6IkFQSUNsaWVudDFfMTYzNzE3MzExNSIsImlhdCI6MTYzNzE3MzExNSwic3ViIjoiQVBJQ2xpZW50MSIsImNsaWVudCI6IkFQSUNsaWVudDEiLCJkb21haW4iOiJBUElEb21haW4ifQ.IxOEGTkNSukcpDltruJGSVWPF0bU3xlDP_BBZUurHzbRzDsfaS6z9j7D9wQJKhr_tnFNajMYLOVo_o9WGD_sSNF9JHme8xizCsrBducsLoOjVCoRfwbTYJ0ut4mkWD0lrp0UtyIbFHUGdsTje2gLzjjMKRYBAeIU1gwM1c_rHZrjlvzAEXN6D5bLqbYA85omixE35axzqjV4ngquNIOyk2ohmiDFigo-gQiyAdD-I-BEFUcMyT264xi8d0iF6byHQ-c3ZUtvqS2FT4iIdw4aa7mUuwUyYSM3nBU_cKSgNY4VX6iVBB4GGdPOfjexck89FZbqvizNTBRmpc9YroSvQf1btPwwPAJL2p4k4NtWZ9clV4BQqMh2l3Z7c8WOfwdsZj8yv8h40Ig3MMnprVkIZZYNCvNKr1mEuKI5yxynYsZcFqoyvXRKEiPopkheSJU6FrKevm7I0OgPuCMJXIuUyvZm0TzJZwg7mTbSnTPjeMZhyPkUakCgN0Jb-lnIdgyNqU7JhgDib2HEapxOE4t_rso8pIGg7k4YsGec0SwrMABiNJK4VHwjfgVx6R0h2rcQ-Bz-Yg61Gepxj82k-KecknNwx63-4dMJyyYq4HoKBcESY3PIcEI06rii2V9aLZS2V76ZCmDmU00PQDzlSo4-WdTsiJ1sqe4akeUX9K4dpX8";


}
