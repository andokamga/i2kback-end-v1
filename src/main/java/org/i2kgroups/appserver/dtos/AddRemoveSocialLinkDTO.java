package org.i2kgroups.appserver.dtos;

import java.util.List;

import lombok.Data;

@Data
public class AddRemoveSocialLinkDTO {
	private Long companyId;
	private List<SocialLinkDTO> socialLinksDTO;
}
