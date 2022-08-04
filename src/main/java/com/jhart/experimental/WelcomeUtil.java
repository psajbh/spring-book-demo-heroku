package com.jhart.experimental;

public final class WelcomeUtil {
	
    private WelcomeUtil() { }

	public static String generateWelcome(String name) {
        return String.format("Welcome %s", name);
    }
	
}
