package org.i2kgroups.appserver.services.storage;

import org.i2kgroups.appserver.enums.EnumVisualType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("VLS")
public class LocalStorageImpl implements IStorage {

	@Override
	public byte[] getVisual(EnumVisualType type, Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] uploadVisual(MultipartFile file, Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
