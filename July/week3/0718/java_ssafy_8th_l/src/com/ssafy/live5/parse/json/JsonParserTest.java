package com.ssafy.live5.parse.json;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ssafy.live5.parse.BoxOffice;

public class JsonParserTest {
    public static void main(String[] args) {
        UseJson parser = new UseJson();
        List<BoxOffice> list;
		try {
			list = parser.getBoxOffice();
			for(BoxOffice info: list) {
				System.out.println(info);
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }   
}
