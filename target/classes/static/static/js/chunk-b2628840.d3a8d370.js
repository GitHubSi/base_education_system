(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b2628840"],{"1d5d":function(t,e,i){t.exports=i.p+"static/img/henu_logo.4f3a6901.jpg"},2017:function(t,e,i){"use strict";i("cafe")},"2c11":function(t,e,i){"use strict";i("e760")},"2c4f":function(t,e,i){"use strict";i("3b7b")},"3b7b":function(t,e,i){},"81d5":function(t,e,i){"use strict";var n=i("7b0b"),o=i("23cb"),r=i("50c4");t.exports=function(t){var e=n(this),i=r(e.length),s=arguments.length,a=o(s>1?arguments[1]:void 0,i),l=s>2?arguments[2]:void 0,d=void 0===l?i:o(l,i);while(d>a)e[a++]=t;return e}},"9ed6":function(t,e,i){"use strict";i.r(e);var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"login-container"},[t._m(0),i("span",{staticClass:"logo-right"},[t._v("河南大学")]),i("span",{staticClass:"logo-right-eng"},[t._v("Henan University")]),t._m(1),i("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{model:t.loginForm,rules:t.loginRules,"auto-complete":"on","label-position":"left"}},[i("div",{staticClass:"user-login"},[t._v("账号登录")]),i("div",{staticClass:"login_content"},[i("el-form-item",{attrs:{prop:"userNumber"}},[i("span",{staticClass:"svg-container"},[i("svg-icon",{attrs:{"icon-class":"user"}})],1),i("el-input",{ref:"userNumber",attrs:{placeholder:"UserNumber",name:"userNumber",type:"text",tabindex:"1","auto-complete":"on"},model:{value:t.loginForm.userNumber,callback:function(e){t.$set(t.loginForm,"userNumber",e)},expression:"loginForm.userNumber"}})],1),i("el-form-item",{attrs:{prop:"password"}},[i("span",{staticClass:"svg-container"},[i("svg-icon",{attrs:{"icon-class":"password"}})],1),i("el-input",{key:t.passwordType,ref:"password",attrs:{type:t.passwordType,placeholder:"Password",name:"password",tabindex:"2","auto-complete":"on"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.handleLogin(e)}},model:{value:t.loginForm.password,callback:function(e){t.$set(t.loginForm,"password",e)},expression:"loginForm.password"}}),i("span",{staticClass:"show-pwd",on:{click:t.showPwd}},[i("svg-icon",{attrs:{"icon-class":"password"===t.passwordType?"eye":"eye-open"}})],1)],1),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{staticClass:"identifyCode"},[i("el-row",{attrs:{gutter:16}},[i("label",{staticStyle:{"margin-left":"2%"}},[t._v(" 请输入验证码:")]),i("el-input",{staticStyle:{"margin-left":"-2%:heigth:10px",width:"217px"},model:{value:t.myCode,callback:function(e){t.myCode=e},expression:"myCode"}})],1)],1)],1),i("el-col",{staticClass:"codeClass",attrs:{span:8}},[i("div",{on:{click:t.refreshCode}},[i("s-identify",{attrs:{identifyCode:t.identifyCode}})],1)])],1),i("el-button",{staticStyle:{width:"100%","margin-bottom":"30px"},attrs:{loading:t.loading,type:"primary"},nativeOn:{click:function(e){return e.preventDefault(),t.handleLogin(e)}}},[t._v("登录")])],1)])],1)},o=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("span",{staticClass:"logo"},[n("img",{attrs:{src:i("1d5d")}})])},function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"center-section"},[i("div",{staticClass:"title-container"},[i("h1",{staticClass:"title"},[t._v("基层教学组织管理系统")])])])}],r=(i("61f7"),function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"s-canvas"},[i("canvas",{attrs:{id:"s-canvas",width:t.contentWidth,height:t.contentHeight}})])}),s=[],a=(i("a9e3"),i("cb29"),{name:"SIdentify",props:{identifyCode:{type:String,default:"1234"},fontSizeMin:{type:Number,default:25},fontSizeMax:{type:Number,default:30},backgroundColorMin:{type:Number,default:255},backgroundColorMax:{type:Number,default:255},colorMin:{type:Number,default:0},colorMax:{type:Number,default:160},lineColorMin:{type:Number,default:100},lineColorMax:{type:Number,default:255},dotColorMin:{type:Number,default:0},dotColorMax:{type:Number,default:255},contentWidth:{type:Number,default:128},contentHeight:{type:Number,default:46}},methods:{randomNum:function(t,e){return Math.floor(Math.random()*(e-t)+t)},randomColor:function(t,e){var i=this.randomNum(t,e),n=this.randomNum(t,e),o=this.randomNum(t,e);return"rgb("+i+","+n+","+o+")"},drawPic:function(){var t=document.getElementById("s-canvas"),e=t.getContext("2d");e.textBaseline="bottom",e.fillStyle=this.randomColor(this.backgroundColorMin,this.backgroundColorMax),e.fillRect(0,0,this.contentWidth,this.contentHeight);for(var i=0;i<this.identifyCode.length;i++)this.drawText(e,this.identifyCode[i],i);this.drawLine(e),this.drawDot(e)},drawText:function(t,e,i){t.fillStyle=this.randomColor(this.colorMin,this.colorMax),t.font=this.randomNum(this.fontSizeMin,this.fontSizeMax)+"px SimHei";var n=(i+1)*(this.contentWidth/(this.identifyCode.length+1)),o=this.randomNum(this.fontSizeMax,this.contentHeight-5),r=this.randomNum(-45,45);t.translate(n,o),t.rotate(r*Math.PI/180),t.fillText(e,0,0),t.rotate(-r*Math.PI/180),t.translate(-n,-o)},drawLine:function(t){for(var e=0;e<5;e++)t.strokeStyle=this.randomColor(this.lineColorMin,this.lineColorMax),t.beginPath(),t.moveTo(this.randomNum(0,this.contentWidth),this.randomNum(0,this.contentHeight)),t.lineTo(this.randomNum(0,this.contentWidth),this.randomNum(0,this.contentHeight)),t.stroke()},drawDot:function(t){for(var e=0;e<80;e++)t.fillStyle=this.randomColor(0,255),t.beginPath(),t.arc(this.randomNum(0,this.contentWidth),this.randomNum(0,this.contentHeight),1,0,2*Math.PI),t.fill()}},watch:{identifyCode:function(){this.drawPic()}},mounted:function(){this.drawPic()}}),l=a,d=(i("2c4f"),i("2877")),c=Object(d["a"])(l,r,s,!1,null,"4f12c0ba",null),u=c.exports,f={components:{SIdentify:u},name:"Login",data:function(){var t=function(t,e,i){e.length<6?i(new Error("The password can not be less than 6 digits")):i()};return{myCode:"",identifyCode:"",identifyCodes:"1234567890abcdefjhijklinopqrsduvwxyz",loginForm:{userNumber:"1925050351",password:"123456"},loginRules:{password:[{required:!0,trigger:"blur",validator:t}]},loading:!1,passwordType:"password",redirect:void 0}},watch:{$route:{handler:function(t){this.redirect=t.query&&t.query.redirect},immediate:!0}},methods:{refreshCode:function(){this.identifyCode="",this.makeCode(this.identifyCodes,4)},makeCode:function(t,e){for(var i=0;i<e;i++)this.identifyCode+=this.identifyCodes[this.randomNum(0,this.identifyCodes.length)]},randomNum:function(t,e){return Math.floor(Math.random()*(e-t)+t)},showPwd:function(){var t=this;"password"===this.passwordType?this.passwordType="":this.passwordType="password",this.$nextTick((function(){t.$refs.password.focus()}))},handleLogin:function(){var t=this;this.myCode!=this.identifyCode?(this.$message.error("验证码错误！"),this.refreshCode()):this.$refs.loginForm.validate((function(e){if(!e)return console.log("error submit!!"),!1;t.loading=!0,t.$store.dispatch("user/login",t.loginForm).then((function(){t.$router.push({path:t.redirect||"/"}),t.loading=!1})).catch((function(){t.loading=!1}))}))}},mounted:function(){this.identifyCode="",this.makeCode(this.identifyCodes,4)}},h=f,m=(i("2017"),i("2c11"),Object(d["a"])(h,n,o,!1,null,"618b09b0",null));e["default"]=m.exports},a9e3:function(t,e,i){"use strict";var n=i("83ab"),o=i("da84"),r=i("94ca"),s=i("6eeb"),a=i("5135"),l=i("c6b6"),d=i("7156"),c=i("c04e"),u=i("d039"),f=i("7c73"),h=i("241c").f,m=i("06cf").f,p=i("9bf2").f,g=i("58a8").trim,y="Number",C=o[y],b=C.prototype,v=l(f(b))==y,w=function(t){var e,i,n,o,r,s,a,l,d=c(t,!1);if("string"==typeof d&&d.length>2)if(d=g(d),e=d.charCodeAt(0),43===e||45===e){if(i=d.charCodeAt(2),88===i||120===i)return NaN}else if(48===e){switch(d.charCodeAt(1)){case 66:case 98:n=2,o=49;break;case 79:case 111:n=8,o=55;break;default:return+d}for(r=d.slice(2),s=r.length,a=0;a<s;a++)if(l=r.charCodeAt(a),l<48||l>o)return NaN;return parseInt(r,n)}return+d};if(r(y,!C(" 0o1")||!C("0b1")||C("+0x1"))){for(var N,x=function(t){var e=arguments.length<1?0:t,i=this;return i instanceof x&&(v?u((function(){b.valueOf.call(i)})):l(i)!=y)?d(new C(w(e)),i,x):w(e)},M=n?h(C):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","),k=0;M.length>k;k++)a(C,N=M[k])&&!a(x,N)&&p(x,N,m(C,N));x.prototype=b,b.constructor=x,s(o,y,x)}},cafe:function(t,e,i){},cb29:function(t,e,i){var n=i("23e7"),o=i("81d5"),r=i("44d2");n({target:"Array",proto:!0},{fill:o}),r("fill")},e760:function(t,e,i){}}]);