package com.cos.book.domain.user;

import org.junit.Test;

public class RoleTest {
	
	@Test
	public void 롤_사용법() {
		System.out.println(Role.GUEST);
		System.out.println(Role.GUEST.getKey());
		System.out.println(Role.GUEST.getTitle());
		System.out.println(Role.values().length);
		System.out.println("------");
		System.out.println(Role.GUEST.name());
		System.out.println("------");
		System.out.println(Role.GUEST.ordinal());
		System.out.println();
		
		for(Role r : Role.values()) {
			if(r.ordinal() == 0) {
				System.out.println(r.getKey());
			}
			
			if(r.getKey().equals("ROLE_GUEST")) {
				System.out.println(r.getTitle());
			}
		}
	}
}
