package org.i2kgroups.appserver.dtos;

import org.i2kgroups.appserver.enums.EnumSocialLink;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;


@Data
public class SocialLinkDTO {

	private Long id;
    @Enumerated(EnumType.STRING)
	private EnumSocialLink name;
	private String link;
}
