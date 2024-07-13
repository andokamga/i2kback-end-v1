package org.i2kgroups.appserver.services.storage;

import org.i2kgroups.appserver.enums.EnumVisualType;
import org.springframework.web.multipart.MultipartFile;

public interface IStorage {
	
	public byte[] getVisual(EnumVisualType type, Long id) throws Exception;
	public byte[] uploadVisual(MultipartFile file,Long id) throws Exception;
}
