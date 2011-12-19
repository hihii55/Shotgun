package com.thebkkingdom.Shotgun;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ShotgunLogger {

	private static final Logger log = Logger.getLogger("Shotgun");
	
	public static void log(Level level, String content){
		log.log(level, Shotgun.getPrefix() + content);
	}
}
