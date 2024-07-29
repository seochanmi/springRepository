package com.example.boot11.dto;

	import lombok.AllArgsConstructor;
	import lombok.Builder;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	@Builder    // .action().action2()... 형태로 객체를 만들수 있게 해준다.
	@AllArgsConstructor    // 모든 인자를 전달받는 생성자
	@NoArgsConstructor    // default 생성자
	@Data    // setter, getter 메소드 등을 만들어준다.
	public class ProductDto {
	    // 숫자로 된 아이디는 PK
	    private int productId;
	    // 제품명은 중복된 데이터가 들어가지 않도록 UNIQUE KEY를 설정해야 한다
	    private String productName;
	    private String description;
	    private int quantity;
	    // 제품의 카테고리를 저장할 칼럼
	    private String category;
	    private String supplier;
	    private String addedDate;
	}
/*
 * 
 *  CREATE TABLE user_pro
      (productId NUMBER PRIMARY KEY,
      productName VARCHAR2(20) UNIQUE,
      description VARCHAR2(100) NOT NULL,
       quantity Number,
       category VARCHAR2(100) NOT NULL,
              supplier VARCHAR2(100) not null,
               addedDate varchar2(100) not null
      );
 * 
 * */
