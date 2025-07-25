package com.sinse.mall.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="topcategory")
public class TopCategory {
	@Id
	private int topcategory_id;
	private String top_name;
	
	//자식인 SubCategory 리스트
	@Transient
	private List<SubCategory> subList; //1:多 관계이므로 자식을 collection으로 수집한다. 만일, 자식도 부모를 같이 참조하고 있을 경우, 무한루프를 조심한다.
}
