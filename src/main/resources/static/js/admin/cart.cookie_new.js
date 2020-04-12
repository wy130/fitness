var app=(function($,undefined){
	var util={
	    //验证字符串是否为空
		isEmpty:function(str){
			return (typeof str== 'undefined' || str==null || str =='');
		},

		isNotEmpty:function(v){
			return !util.isEmpty(v);
		},
		
		isNumber:function(v) {
			return new RegExp(/^\d+$/).test(v);
		},
		
		//数量加1
		add:function(id, num, type) {
			num = num || 1;
			var choc = -1;
			var dispro = -1;
			
			$.each(pageData.cartData, function(key, val) {
			    var proid = val[0];
				var count = parseInt(val[1]);
				
				if(id == proid) {
					var counts = count + num;
					if(type) {
						counts = num;
					}
					var max_num = parseInt($("#cart_count_"+id).attr("data-num")||1);
					if(counts > max_num) {
						alert("您输入的数量超过产品上限，你最多可以购买"+max_num+"个！");
						counts = max_num;
					}
					if(counts > 0) {
						pageData.cartData[key][1] = counts;
						
						$("#cart_count_"+id).val(counts);
					}
				}
				//如果是特殊产品
				if(proid==3467){
					choc = proid
				}
				
				//满赠逻辑，活动过后删掉
				var proid2 = proid;
				var key2 = proid;
					if(proid2 == 365) {
						dispro = key2;
					}
					if(proid2 == 366) {
						dispro = key2;
					}
					if(proid2 == 367) {
						dispro = key2;
					}
					if(proid2 == 412) {
						dispro = key2;
					}
					if(proid2 == 413) {
						dispro = key2;
					}
					if(proid2 == 446) {
						dispro = key2;
					}
					if(proid2 == 448) {
						dispro = key2;
					}
					if(proid2 == 449) {
						dispro = key2;
					}
					if(proid2 == 450) {
						dispro = key2;
					}
					if(proid2 == 451) {
						dispro = key2;
					}
					if(proid2 == 452) {
						dispro = key2;
					}
					if(proid2 == 453) {
						dispro = key2;
					}
					if(proid2 == 627) {
						dispro = key2;
					}
					if(proid2 == 636) {
						dispro = key2;
					}
					if(proid2 == 637) {
						dispro = key2;
					}
					if(proid2 == 652) {
						dispro = key2;
					}
					
					//满赠逻辑end
				
			});
			
			util.setCookie();
			//如果是附赠优惠购买产品，根据金额标准判断是否显示添加优惠产品文本，判断是否勾选
			if(choc>-1){
				if(util.getTotalPrice()<1098){
					$("#addChocolateSpan").hide();
					util.del(3467);
				}else{
					$("#addChocolateSpan").show();
				}
			}else{
				if(util.getTotalPrice()<999){
					$("#addChocolateSpan").hide();
				}else{
					$("#addChocolateSpan").show();
					$("#addChocolate").prop("checked", false);  
				}
			}
			
			//满赠逻辑，活动过后删掉
				if(dispro>-1){
					location.reload();
				}
			//满赠逻辑end
			
			
		},
		
		//删除产品
		del:function (id) {
			var i = -1;
			$.each(pageData.cartData, function(key, val) {
			    var proid = val[0];
				
				if(id == proid) {
					i = key;
				}
			});
			
			if(i > -1) {
				pageData.cartData.splice(i,1);
					
				$("#cart_tr_"+id).hide();
				
				util.setCookie();
				util.setSort();
				
				//礼品处理
				join_util.del_p(id, 0);
			}
			
			//删除其他产品后，判断购物车是否有优惠购买的巧克力，如果金额不够删除巧克力，是否显示添加文本，是否勾选
			if(id!=3467){
				var choc = -1;
				var dispro = -1;
				$.each(pageData.cartData, function(key2, val2) {
			    	var proid2 = val2[0];
				
					if(proid2 == 3467) {
						choc = key2;
					}
					
					//满赠逻辑，活动过后删掉
					if(proid2 == 365) {
						dispro = key2;
					}
					if(proid2 == 366) {
						dispro = key2;
					}
					if(proid2 == 367) {
						dispro = key2;
					}
					if(proid2 == 412) {
						dispro = key2;
					}
					if(proid2 == 413) {
						dispro = key2;
					}
					if(proid2 == 446) {
						dispro = key2;
					}
					if(proid2 == 448) {
						dispro = key2;
					}
					if(proid2 == 449) {
						dispro = key2;
					}
					if(proid2 == 450) {
						dispro = key2;
					}
					if(proid2 == 451) {
						dispro = key2;
					}
					if(proid2 == 452) {
						dispro = key2;
					}
					if(proid2 == 453) {
						dispro = key2;
					}
					if(proid2 == 627) {
						dispro = key2;
					}
					if(proid2 == 636) {
						dispro = key2;
					}
					if(proid2 == 637) {
						dispro = key2;
					}
					if(proid2 == 652) {
						dispro = key2;
					}
					//满赠逻辑end
				});
			
				if(choc > -1&&util.getTotalPrice()<1098) {
					pageData.cartData.splice(choc,1);
					
					$("#cart_tr_3467").hide();
					$("#addChocolateSpan").hide();
					
					util.setCookie();
					util.setSort();
				
					//礼品处理
					join_util.del_p(id, 0);
				}else if(util.getTotalPrice()<999){
					$("#addChocolateSpan").hide();
				}
				
				//满赠逻辑，活动过后删掉
				if(dispro>-1){
					location.reload();
				}
				//满赠逻辑end
			}else{
				$("#addChocolate").prop("checked", false);  
			}
		},
		
		delAll:function() {
			pageData.cartData = [];
				
			util.setCookie();
				
			$(".shopping_cart tr").not(":first").hide();
			//$(".shopping_cart tr:not(:first)").hide();
			//$(".shopping_cart tr:gt(0)").hide();
			//$(".shopping_cart tr").filter(":not(:first)").hide();
			
			//礼品处理
			join_util.delAll();
			//清空购物车后隐藏添加优惠产品按钮
			$("#addChocolateSpan").hide();
		},
		
		getTotalPrice:function() {
			var totalPrice = 0;
			$.each(pageData.cartData, function(key, val) {
			    var proid = val[0];
				var count = parseInt(val[1]);
				
				var price = parseFloat($("#cart_tr_"+proid+" td").eq(3).text().substring(1));
				totalPrice += price * count;
			});
			
			$("#cartNum").text("("+pageData.cartData.length+")");

			return totalPrice;
		},
		
		setSort:function() {
			$.each(pageData.cartData, function(key, val) {
			    var proid = val[0];
				var v = key+1;
				$("#cart_tr_"+proid+" td").eq(0).text(v);
			});
		},
		
		cookieDate: function() {
			var mydata = [];
			var cart_data = util.getCookieByName();
			var arr_1 = cart_data.split("#");
			for(var i=0; i<arr_1.length; i++) {
				var arr_2 = arr_1[i].split("_");
				if(arr_2.length == 3) {
					mydata.push(arr_2);
				}
			}
			pageData.cartData = mydata;
		},
		
		setCookie:function () {
			var cookieValue = "";
			var as = [];
			$.each(pageData.cartData, function(key, val) {
			    
				as.push(val.join('_'));
			});
			if(as.length>0){
				cookieValue = as.join("#")+"#";
			}
			util.mycookie(pageData.cookieName, cookieValue, {expires:7, path:'/', domain:pageData.cookieDomain, secure:false, raw:false});
			
			util.getTotalPrice();
			
			//礼品处理，刷新总金额
			app.getTotalPrice();
		},
		
		getCookieByName:function() {
			return util.mycookie(pageData.cookieName) || "";
		},
		
		getCookieUserid:function() {
			return util.mycookie(pageData.cookieUser) || "";
		},
		
		mycookie:function(e,t,n){if(typeof t=="undefined"){var a=null;if(document.cookie&&document.cookie!=""){var f=document.cookie.split(";");for(var l=0;l<f.length;l++){var c=jQuery.trim(f[l]);if(c.substring(0,e.length+1)==e+"="){a=c.substring(e.length+1);break}}}return a}n=n||{},t===null&&(t="",n.expires=-1);var r="";if(n.expires&&(typeof n.expires=="number"||n.expires.toUTCString)){var i;typeof n.expires=="number"?(i=new Date,i.setTime(i.getTime()+n.expires*24*60*60*1e3)):i=n.expires,r="; expires="+i.toUTCString()}var s=n.path?"; path="+n.path:"",o=n.domain?"; domain="+n.domain:"",u=n.secure?"; secure":"";document.cookie=[e,"=",t,r,s,o,u].join("")}
	};
	
	var join_util={
		//删除产品
		del_p:function (pid, ppid) {
			var child = [];
			$.each(pageData.joinData, function(key, val) {
			    var pid_ = val[0];
				var id_ = val[1];
				var ppid_ = val[3] || 0;
				
				if(pid_ == pid && ppid_ == ppid) {
					child.push([id_, pid_, ppid_]);
				}
			});
			$.each(child, function(key, val) {
				join_util.del(val[0], val[1],val[2]);
			});
		},
		
		//删除产品
		del:function (id, pid, ppid) {
			var i = -1;
			$.each(pageData.joinData, function(key, val) {
				var pid_ = val[0];
			    var id_ = val[1];
				
				if(id == id_ && pid == pid_) {
					console.log(pid,pid_);
					i = key;
				}
			});
			
			if(i > -1) {
				pageData.joinData.splice(i,1);
				
				if(ppid == 0) {
					$("#cart_tr_"+id+"_"+pid).hide();
					join_util.del_p(id, pid);
				} else {
					$("#cart_tr_"+id+"_"+pid+"_"+ppid).hide();
				}
				
				join_util.setCookie();
				
				
			}
		},
		
		getPid:function(id) {
			var pid = 0;
			$.each(pageData.joinData, function(key, val) {
				var pid_ = val[0];
			    var id_ = val[1];
				
				if(id == id_) {
					pid = pid_;
				}
			});
			return pid;
		},
		
		delAll:function() {
			pageData.joinData = [];
				
			join_util.setCookie();
		},
		
		getTotalPrice:function() {
			var totalPrice = 0;
			$.each(pageData.joinData, function(key, val) {
				var pid = val[0];
			    var id = val[1];
				var count = Math.abs(parseInt(val[2]));
				
				var objs = $(".td_price_"+id);
				var price = 0;
				if(objs.length == 1) {
					price = parseFloat(objs.text().substring(1));
				} 
				if(objs.length > 1) {
					price = parseFloat($(objs[0]).text().substring(1));
				} 
				//var price = parseFloat($("#cart_tr_"+id+"_"+pid+" td").eq(2).text().substring(1));
				totalPrice += price * count;
			});
			
			return totalPrice;
		},
		
		cookieDate: function() {
			var mydata = [];
			var cart_data = join_util.getCookieByName();
			var arr_1 = cart_data.split("#");
			for(var i=0; i<arr_1.length; i++) {
				var arr_2 = arr_1[i].split("_");
				if(arr_2.length == 3 || arr_2.length == 4) {
					//var a_3 = Math.abs(parseInt(arr_2[2]));
					//arr_2[2] = a_3;
					mydata.push(arr_2);
				}
			}
			pageData.joinData = mydata;
		},
		
		setCookie:function () {
			var cookieValue = "";
			var as = [];
			$.each(pageData.joinData, function(key, val) {
			    
				as.push(val.join('_'));
			});
			if(as.length>0){
				cookieValue = as.join("#")+"#";
			}
			util.mycookie(pageData.cookieNameJoin, cookieValue, {expires:7, path:'/', domain:pageData.cookieDomain, secure:false, raw:false});
			
			app.getTotalPrice();
		},
		
		getCookieByName:function() {
			return util.mycookie(pageData.cookieNameJoin) || "";
		}
	}

	var pageData={
		mybasePath:"",
		cookieName:"my_card_productid_count",
		cookieNameJoin:"my_card_productid_join",
		cookieUser:"index_cookiename",
		cookieDomain:".roseonly.com.cn",
		cartData:[],
		joinData:[]
	}

	var app={
		getTotalPrice:function() {
			var totalPrice = util.getTotalPrice();//+join_util.getTotalPrice();
			$("#cart_total").text(totalPrice+".0");		
			
		}
	};
	
	var fun={
		init:function() {
			//初始化购物车数据
			util.cookieDate();
			join_util.cookieDate();
			
			//监听清空事件
			$("#cart_del_all").bind("click",function() {
				util.delAll();
			});
			
			//监听删除产品事件
			$(".cart_del").bind("click",function() {
				var proid = $(this).parents("tr").attr("data-id");
				var proname=$(this).parents("tr").children('td:eq(2)').children("div.shopping_cart_name").text();
				var price=$(this).parents("tr").children('td:eq(3)').text().substr(1);
				var pronum=$(this).parents("tr").children('td:eq(5)').children('input').val();
				yima_del(proid,proname,price,pronum);
				util.del(proid);
			});
			
			
			function yima_del(proid,proname,price,pronum){
				var inneruserid = util.getCookieUserid();
				_adwq.push([ '_setDataType', 
				'delete' // 指定数据类型为删除购物车 - 固定值 - 必填项
				]); 

				_adwq.push([ '_setCustomer', 
				'' // 请输入用户会员ID或用户名 
				]); 

				_adwq.push(['_setItem', 
				proid, // 请填入商品编号 - 必填项 
				proname, // 请填入商品名称 - 必填项 
				price, // 请填入商品金额 - 必填项 
				pronum, // 请填入商品数量 - 必填项 
				'商品分类编号', // 请填入商品分类编号 - 必填项 
				'商品分类名称' // 请填入商品分类名称 - 必填项 
				]); 

				_adwq.push([ '_trackTrans' ]); // 触发删除购物车数据提交 - 固定值 - 必填项
				
			}
			
			//监听添加产品数量事件
			$(".cart_up").bind("click",function() {
				var proid = $(this).parents("tr").attr("data-id");
				
				util.add(proid, 1);
			});
			
			//监听减少产品数量事件
			$(".cart_down").bind("click",function() {
				var proid = $(this).parents("tr").attr("data-id");
				
				util.add(proid, -1);
			});
			
			//监听改变产品数量事件
			$(".shopping_cart_sl").bind("blur",function() {
				var proid = $(this).parents("tr").attr("data-id");
				var num = parseInt($(this).val());
				
				util.add(proid, num, "blur");
			});
			
			//监听关联产品删除事件
			$(".cart_join_del").bind("click",function() {
				var id = $(this).parents("tr").attr("data-id");
				var pid = $(this).parents("tr").attr("data-pid");
				var ppid = $(this).parents("tr").attr("data-ppid");
				
				join_util.del(id, pid, ppid);
			});
			
			//监听改变产品数量事件
			$("#cart_pay").bind("click",function() {
				var user = util.mycookie(pageData.cookieUser) || "";
				var address_shop_id = $(".shopping_cart").attr("data-shopid") || "0";
				if(address_shop_id == '0') {
					
					if($.trim(user) == '' || !util.isNumber(user)) {
						var bodyTop = 0;
						 if (typeof window.pageYOffset != 'undefined') {
				            bodyTop = window.pageYOffset
				        } else if (typeof document.compatMode != 'undefined' && document.compatMode != 'BackCompat') {
				            bodyTop = document.documentElement.scrollTop
				        } else if (typeof document.body != 'undefined') {
				            bodyTop = document.body.scrollTop
				        }
						window.location.href="http://orders.roseonly.com.cn/pcEntrance/tologin?url=http://orders.roseonly.com.cn/cart/seeMyCart";
					} else {
						fun.pay();
					}
				} else {
					fun.pay();
				}
			});
			
			//监听查看更多产品事件
			$("#product_more").bind("click",function() {
				if($(".zs_xqmore_ul li:gt(2)").is(":hidden")) {
					$(".zs_xqmore_ul li:gt(2)").slideDown("slow");
				} else {
					$(".zs_xqmore_ul li:gt(2)").slideUp("slow");
				}
			});
		},
		
		pay:function() {
			$.getJSON(pageData.mybasePath+"/cart/pay?callback=?",null,function(data){
				//判断购物车数量[{pays:'0', msg: '1', size:'1'}]
				var size = data.size;
				if(size == '0') {
					alert("你的购物车没有产品！");
				} 
				if(size == '1') {
					var address_shop_id = $(".shopping_cart").attr("data-shopid");
					if(address_shop_id == '0') {
						window.self.location = pageData.mybasePath+"/userAddressinfo/payAddress";
					} else {//实体店购买
						window.self.location = pageData.mybasePath+"/userAddressinfoShop/payAddress/"+address_shop_id;
					}
				}
				if(size == '2') {
					alert("购物车数据错误，不能下单！");
				}
			});
		}
	}
			
	//dom ready
	$(function(){
		pageData.mybasePath = $("#mybasePath").text();
		
		fun.init();
	});	

	return app;
			
})(jQuery);




 