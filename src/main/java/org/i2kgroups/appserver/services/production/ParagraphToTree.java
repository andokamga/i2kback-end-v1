package org.i2kgroups.appserver.services.production;

import java.util.List;

import org.i2kgroups.appserver.dtos.ParagraphDTO;
import org.i2kgroups.appserver.dtos.ParagraphListDTO;
import org.i2kgroups.appserver.dtos.TextDTO;
import org.i2kgroups.appserver.entities.Paragraph;
import org.i2kgroups.appserver.entities.Text;
import org.i2kgroups.appserver.entities.paragraphList;
import org.i2kgroups.appserver.enums.EnumParagraphType;
import org.i2kgroups.appserver.mappers.IProductionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParagraphToTree {
	@Autowired
	public IProductionMapper iProductionMapper;
	
	public void addParagraphToTreeDTO(List<Paragraph> ps,int hauteur,ParagraphListDTO paragraph,int niveau) {
		if(hauteur>niveau) {
			for(Paragraph p:ps) {
				if(p.getLevel()!=0) {
					if(paragraph.getId()==p.getParagraph().getId()) {
						if(p instanceof paragraphList) {
							ParagraphListDTO pa= new ParagraphListDTO();
							pa.setId(p.getId());
							pa.setTypep(EnumParagraphType.PARAGRAPH);
							ParagraphListDTO pc = (ParagraphListDTO) paragraph.addChild(pa);
							addParagraphToTreeDTO(ps,hauteur, pc,niveau-1);
						}else {
							TextDTO t1 =iProductionMapper.textConvertToTextDTO((Text) p);
							TextDTO t = new TextDTO();
							t.setId(t1.getId());
							t.setLevel(t1.getLevel());
							t1.setTypep(EnumParagraphType.TEXT);
							paragraph.addChild(t1);

						}
					}
				}

			}
		
		}
		
	}
	public ParagraphDTO paragraphToparagraphTreeDTO(List<Paragraph> ps) {
		int hauteur=0;
		ParagraphListDTO paragraph= new ParagraphListDTO();
		for(Paragraph p:ps) {
			if(p.getLevel()>hauteur) {
				hauteur=p.getLevel();
			}
			if(p.getLevel()==0) { 
				paragraph.setLevel(0);
				paragraph.setId(p.getId());

			}
		}
		addParagraphToTreeDTO(ps,hauteur,paragraph,1);
		return paragraph;
	}

}
