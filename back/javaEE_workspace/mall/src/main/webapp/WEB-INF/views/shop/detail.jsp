<%@page import="com.sinse.mall.domain.ProductSize"%>
<%@page import="com.sinse.mall.domain.ProductColor"%>
<%@page import="com.sinse.mall.domain.ProductImg"%>
<%@page import="com.sinse.mall.domain.Product"%>
<%@page import="com.sinse.mall.domain.SubCategory"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
		Product product = (Product)request.getAttribute("product");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ashion | Template</title>
	<%@ include file="./inc/head_link.jsp" %>
	
</head>

<body>
    <!-- Page Preloder -->
	<%@ include file="./inc/preloader.jsp" %>
	
    <!-- Offcanvas Menu Begin -->
	<%@ include file="./inc/offcanvas.jsp" %>
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
	<%@ include file="./inc/header.jsp" %>
    <!-- Header Section End -->
	
	<!-- 내용 Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__left product__thumb nice-scroll">
                        
                            <%for(int i=0; i<product.getImgList().size(); i++){ %>
                            <%ProductImg productImg = product.getImgList().get(i); %>
                            <a class="pt active" href="#product-1">
                                <img src="/data/p_<%=product.getProduct_id() %>/<%=productImg.getFilename() %>" alt="">
                            </a>
                            <%} %>
                            
                        </div>
                        <div class="product__details__slider__content">
                            <%for(int i=0; i<product.getImgList().size(); i++){ %>
                            <%ProductImg productImg = product.getImgList().get(i); %>
                            <div class="product__details__pic__slider owl-carousel">
                                <img data-hash="product-1" class="product__big__img" src="/data/p_<%=product.getProduct_id() %>/<%=productImg.getFilename() %>" alt="">
                            </div>
                            <%} %>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="product__details__text">
                        <h3>Essential structured blazer <span>Brand: <%=product.getBrand() %></span></h3>
                        <div class="rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <span>( 138 reviews )</span>
                        </div>
                        <div class="product__details__price"><%=product.getDiscount() %><span><%=product.getPrice() %></span></div>
                        <p>Nemo enim ipsam voluptatem quia aspernatur aut odit aut loret fugit, sed quia consequuntur
                        magni lores eos qui ratione voluptatem sequi nesciunt.</p>
                        <div class="product__details__button">
                            <div class="quantity">
                                <span>Quantity:</span>
                                <div class="pro-qty">
                                    <input type="text" id="ea" value="1">
                                </div>
                            </div>
                            <%if(loginMember!=null){ %>
                            <a href="javascript:addCart(<%=loginMember.getMember_id() %>)" class="cart-btn"><span class="icon_bag_alt"></span> Add to cart</a>
                            <%} else { %>
                            <a href="javascript:alert('로그인이 필요한 서비스입니다')" class="cart-btn"><span class="icon_bag_alt"></span> Add to cart</a>
                            <%} %>
                            <ul>
                                <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                <li><a href="#"><span class="icon_adjust-horiz"></span></a></li>
                            </ul>
                        </div>
                        <div class="product__details__widget">
                            <ul>
                                <li>
                                    <span>Availability:</span>
                                    <div class="stock__checkbox">
                                        <label for="stockin">
                                            In Stock
                                            <input type="checkbox" id="stockin">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <span>Available color:</span>
                                    <div class="color__checkbox">
                                        <%for(ProductColor productColor : product.getColorList()){ %>
                                        <%String color = productColor.getColor().getColor_name(); %>
                                        <label for="<%=color.toLowerCase() %>">
                                            <input type="radio" name="color" id="<%=color.toLowerCase() %>" value="<%=productColor.getColor().getColor_id()%>">
                                            <span class="checkmark <%=color.toLowerCase() %>-bg" style="background: <%=color %>"></span>
                                        </label>
                                        <%} %>
                                    </div>
                                </li>
                                <li>
                                    <span>Available size:</span>
                                    <div class="size__btn">
                                    <%for(ProductSize productSize : product.getSizeList()){ %>
                                    <%String size = productSize.getSize().getSize_name(); %>
                                        <label for="<%=size.toLowerCase() %>-btn" class="active">
                                            <input type="radio" name="size" id="<%=size.toLowerCase() %>-btn" value="<%=productSize.getSize().getSize_id() %>">
                                            <%=size %>
                                        </label>
                                    <%} %>
                                    </div>
                                </li>
                                <li>
                                    <span>Promotions:</span>
                                    <p>Free shipping</p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">Description</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">Specification</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab">Reviews ( 2 )</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <h6>Description</h6>
                                <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed
                                    quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt loret.
                                    Neque porro lorem quisquam est, qui dolorem ipsum quia dolor si. Nemo enim ipsam
                                    voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed quia ipsu
                                    consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Nulla
                                consequat massa quis enim.</p>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                    dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes,
                                    nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
                                quis, sem.</p>
                            </div>  
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<!-- 내용 End -->
	
	<!-- Instagram Begin -->
	<%@ include file="./inc/instagram.jsp" %>	
	<!-- Instagram End -->

	<!-- Footer Section Begin -->
	<%@ include file="./inc/footer.jsp" %>
	<!-- Footer Section End -->

	<!-- Search Begin -->
	<%@ include file="./inc/search.jsp" %>
	<!-- Search End -->

	<!-- Js Plugins -->
	<%@ include file="./inc/footer_link.jsp" %>
	<script type="text/javascript">
		function getSelectedValue(array){
			let selectedValue=0; //색상, 사이즈의 pk
			
			for(let i=0; i<array.length; i++){
				if(array[i].checked){
					selectedValue = array[i].value;
				}
			}
			
			return selectedValue;
		}
		
		function addCart(member_id){
			//유저가 선택한 색상
			
			//유저가 선택한 사이즈
			
			$.ajax({
				url:"/shop/cart/regist",
				type:"post",
				data:{
					"product.product_id" : <%=product.getProduct_id()%>,
					"ea": $("#ea").val(),
					"member.member_id": member_id, 
					"color.color_id" : getSelectedValue(document.getElementsByName("color")), 
					"size.size_id" : getSelectedValue(document.getElementsByName("size"))
				},
				success:function(result, status, xhr){
					console.log("성공", result);
					if(confirm("장바구니 담기 성공\n장바구니로 이동하시겠습니까?")){
						location.href="/shop/cart/list";
					}
				},
				error:function(xhr, status, err){ //200번대 이외의 status에 대한 응답
					console.log("실패 응답 코드는", xhr.status);
					console.log("서버의 실패 메시지는", xhr.responseJSON.msg);
				}
			});
		}
	</script>
	
</body>

</html>