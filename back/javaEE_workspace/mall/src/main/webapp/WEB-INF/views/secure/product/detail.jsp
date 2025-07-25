<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.sinse.mall.domain.ProductImg"%>
<%@page import="com.sinse.mall.domain.Product"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Product product = (Product)request.getAttribute("product");
	
	ObjectMapper mapper = new ObjectMapper();
	
	int[] colorArray = new int[product.getColorList().size()];
	for(int i=0; i<colorArray.length; i++){
		colorArray[i] = product.getColorList().get(i).getColor().getColor_id();
	}
	String colorJson = mapper.writeValueAsString(colorArray);
	
	int[] sizeArray = new int[product.getSizeList().size()];
	for(int i=0; i<sizeArray.length; i++){
		sizeArray[i] = product.getSizeList().get(i).getSize().getSize_id();
	}
	String sizeJson = mapper.writeValueAsString(sizeArray);
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>
	
	<%@ include file="../inc/head_link.jsp" %>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

  <!-- Preloader -->
  <div class="preloader flex-column justify-content-center align-items-center">
    <img class="animation__shake" src="/static/admin/dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60">
  </div>

  <!-- Navbar -->
	<%@ include file="../inc/navbar.jsp" %>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
	<%@ include file="../inc/left_bar.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">상품 확인</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">상품관리>상품확인</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->


    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
      
            <!-- 상품 등록 폼 시작 -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">상품 내용 보기</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form id="form1">
                <div class="card-body">
                	<!-- 카테고리 영역 시작 -->
	                  <div class="row">
	                    <div class="col-sm-6">
	                      <!-- Select multiple-->
	                      <div class="form-group">
	                        <label>상위 카테고리</label>
	                        <select class="form-control" id="topcategory">
	                        </select>
	                      </div>
	                    </div>
	                    <div class="col-sm-6">
	                      <div class="form-group">
	                        <label>하위 카테고리</label>
	                        <select class="form-control" name="subCategory.subcategory_id" id="subcategory">
	                        </select>
	                      </div>
	                    </div>
	                  </div>
                	<!-- 카테고리 영역 끝 -->
                  <div class="form-group">
                    <input type="text" class="form-control" name="product_name" value="<%=product.getProduct_name() %>">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" name="brand" value="<%=product.getBrand()%>">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" name="price" value="<%=product.getPrice() %>">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" name="discount" value="<%=product.getDiscount() %>">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" name="introduce" value="<%=product.getIntroduce() %>">
                  </div>
				   <div class="form-group">
                       <select class="form-control" name ="color" id="color" multiple="multiple">
                         <option>색상 선택</option>
                       </select>
	              </div>
				  
				  <div class="form-group">
                       <select class="form-control" name ="size" id="size" multiple="multiple">
                         <option>사이즈 선택</option>
                       </select>
	              </div>
                  
                  <div class="form-group">
					<!-- 편집 시작 -->
			      	<textarea id="summernote" name="detail"></textarea>
					<!-- 편집기 끝-->
                  </div>
                  
                  <div class="form-group">
                    <div class="input-group">
                      <div class="custom-file">
                        <input type="file" class="custom-file-input" name="photo" id="photo" multiple="multiple">
                        <label class="custom-file-label" for="exampleInputFile">상품 이미지 선택</label>
                      </div>
                      <div class="input-group-append">
                        <span class="input-group-text">Upload</span>
                      </div>
                    </div>
                    	<div id="preview" style="width:100%;" >
                    		미리보기
                    	</div>
                  
                </div>
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="button" class="btn btn-primary" id="bt_regist">상품등록</button>
                  <button type="button" class="btn btn-primary" id="bt_list">목록보기</button>
                </div>
              </form>
            </div>
            <!-- 상품 등록 폼 끝-->
        
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
	<%@ include file="../inc/footer.jsp" %>

  <!-- Control Sidebar -->
	<%//@ include file="../inc/right_bar.jsp" %>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
	<%@ include file="../inc/footer_link.jsp" %>
	<script src="/static/admin/custom/ProductImg.js"></script>
	<script>
	function printCategory(obj, list, v){
		let tag="";
		
		if(obj=="#topcategory"){
			tag+="<option value='0'>상위 카테고리 선택</option>";
			for(let i=0; i<list.length; i++){
				tag+="<option value='"+list[i].topcategory_id+"'>"+list[i].top_name+"</option>";
			}
		}else if(obj=="#subcategory"){
			tag+="<option value='0'>하위 카테고리 선택</option>";
			for(let i=0; i<list.length; i++){
				tag+="<option value='"+list[i].subcategory_id+"'>"+list[i].sub_name+"</option>";
			}
		}else if(obj=="#color"){
			tag+="<option value='0'>색상 선택</option>";
			for(let i=0; i<list.length; i++){
				tag+="<option value='"+list[i].color_id+"'>"+list[i].color_name+"</option>";
			}
		}else if(obj=="#size"){
			tag+="<option value='0'>사이즈 선택</option>";
			for(let i=0; i<list.length; i++){
				tag+="<option value='"+list[i].size_id+"'>"+list[i].size_name+"</option>";
			}
		}
		
		$(obj).html(tag); // innerHTML 태그와 동일하다.
		
		//현재 select 객체의 값 설정
		$(obj).val(v);
	}
	
	//비동기 방식으로 서버에 요청 시도하여, 데이터 가져오기
	function getTopCategory(v){
		$.ajax({
			url:"/admin/admin/topcategory/list",
			type:"get",
			success: function(result, status, xhr){ //200번 대의 성공 응답 시, 이 함수 실행
				console.log("서버로부터 받은 결과는 ", result, v);
				//화면에 출력하기
				printCategory("#topcategory", result, v);
			},
			error: function(xhr, status, err){
			}
		});
	}
	
	function getSubCategory(topcategory_id, v){
		$.ajax({
			url:"/admin/admin/subcategory/list?topcategory_id="+topcategory_id,
			type:"get",
			success: function(result, status, xhr){ //200번 대의 성공 응답 시, 이 함수 실행
				console.log("서버로부터 받은 결과는 ", result, v);
				//화면에 출력하기
				printCategory("#subcategory", result, v);
			}
		});
	}
	
	function getColorList(v){
		$.ajax({
			url:"/admin/admin/color/list",
			type:"get",
			success: function(result, status, xhr){
				console.log("서버로부터 받은 색상은 ", result, v);
				printCategory("#color", result, v);
			}
		});
	}
	
	function getSizeList(v){
		$.ajax({
			url:"/admin/admin/size/list",
			type: "get",
			success: function(result, status, xhr){
				console.log("서버로부터 받은 사이즈는, ", result, v);
				printCategory("#size", result, v);
			}
		})	;
	}
	
	//크롬브라우저에서 지원하는 e.target.files 유사 배열은 읽기전용이기 때문에 개발자에 의해 쓰기가 지원되지 않으므로, 배열을 하나 선언하여 담아서 처리한다.
	//주의) 아래의 배열은 개발자가 정의한 배열일 뿐, form태그가 전송할 컴포넌트는 아니므로, submit시, selectedFile에 들어있는 파일을 전송할 수는 없다.
	//해결책? form태그에 인식을 시켜야 한다. (javascript로 프로그래밍적 formData 객체를 사용해야 한다.)
	//HTML에 작성된 기존 폼에서 텍스트 입력 관련된 컴포넌트는 사용하되, 이미지 업로드 컴포넌트는 재설정해야 한다.
	let selectedFile = [];
	
	function regist(){
		//기존 form을 이용하되, file 컴포넌트 파라미터만 새로 교체(selectedFile 배열로 대체)
		//js에서 프로그래밍적 form 생성
		let formData = new FormData(document.getElementById("form1"));
		
		//formData는 동기/비동기 방식 지원하지만 대부분 비동기방식을 쓴다.
		//Jquery Ajax 자체에서 formData를 비동기방식으로 간단하게 사용할 수 있는 코드를 지원
		//기존 photo를 버리고, 우리가 선언한 배열로 대체
		//formData.append("email", "rhyong1203@gmail.com"); // <input type="text" name="email">과 동일
		//formData는 개발자가 명시하지 않더라도 multipart/form-data가 디폴트값으로 지정되어 있다.
		//기존의 photo 파라미터 제거하기 (append의 반대)
		formData.delete("photo");
		for(let i=0; i<selectedFile.length; i++){
			formData.append("photo", selectedFile[i]);
		}
		
		//파일마저도 비동기로 업로드 가능
		$.ajax({
			url:"/admin/admin/product/regist",
			type:"post",
			data:formData,
			processData:false, /* form을 이루는 데이터 대상이 문자열로 변환되는 것을 방지하기 위해 사용(바이너리 파일이 데이터에 포함되어 있기 때문이다.) */
			contentType:false, /* 브라우저가 자동으로 content-type을 설정하도록 하는 것을 방지하기 위해 사용 */
			success:function(result, status, xhr){
				alert("업로드 성공");
			},
			error:function(xhr, status, err){
				alert(err);
			}
		});
	}
	
	//비동기 방식으로, 서버의 이미지를 다운로드 받기
	function getImgList(dir, filename){
		console.log("넘겨받은 파일명은 ", dir, "/", filename);
		$.ajax({
			url:"/data/" + dir + "/" + filename,
			type:"GET",
			/*
			 	 서버로부터 가져온 이미지 정보는 img src로 표현되려면 다음 과정을 거쳐야 한다.
			 	 1) 서버로부터 가져온 정보를 Blob 형태로 가져온다. Binary Large Object의 준말로 이미지, 오디오, 비디오, 일반 파일 등의 이진 데이터를 담을 수 있는 JS객체 자료형
				 2) 웹브라우저 지원객체인 File로 변환한다.
				 3) 이 파일을 읽어들인 후 e.target.result 형태로 img src에 대입한다.
				 XMLHttpRequest객체를 이용한다...
			*/
			xhr: function(){
				const xhr = new XMLHttpRequest();
				xhr.responseType="blob"; //blob 형태의 데이터 요청
				return xhr;
			},
			success: function(result, status, xhr){ //xhr가 blob형태로 요청하였기 때문에 tomcat은 binary형태로 정보를 넘겨준다.
				console.log("서버로부터 받은 바이너리 정보는 " + result);
				//2단계: 바이너리 서버로부터 전송받은 바이너리 데이터를 이용하여 File 객체로 만들자
				const file = new File([result], filename, {type: result.type});
				
				selectedFile.push(file);
			
				//생성된 File을 읽어들여, img src속성에 대입!!
				const reader = new FileReader();
				reader.onload=function(e){
					console.log("읽어들인 정보는 ", e);
					
					//container, file, src, width, height
					let productImg = new ProductImg(document.getElementById("preview"), file, e.target.result, 100, 100	);
				}
				reader.readAsDataURL(file); //대상 파일 읽기
				
			}
		})
	}
	
	$(()=>{
	   $('#summernote').summernote({
			height:200,
   		});
	   $('#summernote').summernote('code', '<%= product.getDetail() %>');
	   
	   getTopCategory(<%=product.getSubCategory().getTopcategory().getTopcategory_id()%>); //상위 카테고리 가져오기
	   getSubCategory(<%=product.getSubCategory().getTopcategory().getTopcategory_id()%>, <%=product.getSubCategory().getSubcategory_id()%>); //하위 카테고리 가져오기
	   getColorList(<%=colorJson%>); //색상 목록 가져오기
	   getSizeList(<%=sizeJson%>); //사이즈 목록 가져오기
	   
	   //현재 우리가 가진 정보는 filename밖에 없으므로 실제 이미지를 onLoad 시점에 서버로 부터 다운로드 받자
	   <%for(ProductImg productImg : product.getImgList()){%>
	  		 getImgList("p_<%=product.getProduct_id()%>", "<%=productImg.getFilename()%>");
       <%}%>
       
	   //상위 카테고리 값 변경 시, 하위 카테고리 가져오기
	   $("#topcategory").change(function(){ //화살표함수 사용 시 바깥 영역인 Window 전역이 this가 되므로, 익명함수를 사용하였다.
			getSubCategory($(this).val());
	   });
	   
	   //파일 컴포넌트 값 변경 시 이벤트 연결
	   $("#photo").change(function(e){
			console.log(e);
			//e.target.files 안에는 브라우저가 읽어들인, 파일의 정보가 배열 유사 객체인 FileList에 담겨져 있다.
			let files = e.target.files; //배열 유사 객체 접근, 읽기 전용
			
			//첨부된 파일 수만큼 반복
			for(let i=0; i<files.length; i++){
					selectedFile[i]=files[i]; //읽기 전용에 들어있었던 각 file들을 우리만의 배열로 옮기자.
				
				/*파일을 읽기 위한 스트림 객체 생성*/
				const reader = new FileReader();
					
				reader.onload=function(e){//파일을 스트림으로 읽어들인 정보가 e에 들어있음
					console.log("읽은 결과는 ", e);
				
					//개발자 정의 클래스(ProductImg) 인스턴스 생성
					let productImg = new ProductImg(document.getElementById("preview"), files[i], e.target.result, 100, 100);
					
					
					// //e.target.result에 이미지 정보가 들어있다. → img src 속성에 대입 예정
					//let img = document.createElement("img"); //동적으로 이미지 객체 생성 <img>
					//img.src=e.target.result; //이미지 대입 <img src="">
					//img.style.width=100+"px";
					//document.getElementById("preview").appendChild(img);
				}
				reader.readAsDataURL(files[i]); //지정한 파일을 읽기
			}
	   });
	   
	   //등록버튼 이벤트 연결
	   $("#bt_regist").click(()=>{
			regist();
	   });
	   
	   //목록버튼 이벤트 연결
	   $("#bt_list").click(()=>{
			$(location).attr("href", "/admin/admin/product/list");
	   });
	   
	});
	</script>
	
</body>
</html>