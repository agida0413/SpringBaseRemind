package com.sist.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import com.sist.common.MyLogger;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {

	//private final MyLogger myLogger;
	private final MyLogger myLogger;
	
	public void logic(String id) {
		
		myLogger.log("Service id= "+id);
	}
}
