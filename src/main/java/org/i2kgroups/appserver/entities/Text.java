package org.i2kgroups.appserver.entities;

import java.util.ArrayList;
import java.util.List;

import org.i2kgroups.appserver.enums.EnumParagraph;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@DiscriminatorValue("TEXT")
@Builder
public class Text extends Paragraph{
	@Column(length = 500)
	private String description;
	@Enumerated(EnumType.STRING)
	private EnumParagraph type;
	@Default
	@OneToMany(mappedBy = "text",cascade = CascadeType.REMOVE)
	private List<Visual> visuals  = new ArrayList<>();
}
