package org.i2kgroups.appserver.entities;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Entity 
@Data 
@AllArgsConstructor 
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("PARAGRAPH")
@Builder
public class paragraphList extends Paragraph {
	@Default
	@OneToMany(mappedBy = "paragraph",cascade = CascadeType.REMOVE)
	List<Paragraph> Paragraphs=new ArrayList<>();
}
