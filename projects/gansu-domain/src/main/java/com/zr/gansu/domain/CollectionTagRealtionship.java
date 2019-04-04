package com.zr.gansu.domain;

import lombok.Data;

@Data
public class CollectionTagRealtionship {
    private Long id;

    private Long tagId;

    private Long collectionId;
	
	private Long userId;
}