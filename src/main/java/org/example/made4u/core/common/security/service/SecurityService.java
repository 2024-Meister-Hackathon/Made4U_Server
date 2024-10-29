package org.example.made4u.core.common.security.service;

public interface SecurityService {

    Boolean passwordMatches(String rawPassword, String encryptedPassword);

    String getCurrentUserEmail();
}
