webpackJsonp([4],{XJvi:function(e,r){},tcoL:function(e,r,t){"use strict";Object.defineProperty(r,"__esModule",{value:!0});t("M9A7");var s={render:function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("div",{directives:[{name:"title",rawName:"v-title"}],attrs:{id:"register","data-title":"注册 - 码神之路"}},[t("div",{staticClass:"me-login-box me-login-box-radius"},[t("h1",[e._v("码神之路 注册")]),e._v(" "),t("el-form",{ref:"userForm",attrs:{model:e.userForm,rules:e.rules}},[t("el-form-item",{attrs:{prop:"account"}},[t("el-input",{attrs:{placeholder:"用户名"},model:{value:e.userForm.account,callback:function(r){e.$set(e.userForm,"account",r)},expression:"userForm.account"}})],1),e._v(" "),t("el-form-item",{attrs:{prop:"nickname"}},[t("el-input",{attrs:{placeholder:"昵称"},model:{value:e.userForm.nickname,callback:function(r){e.$set(e.userForm,"nickname",r)},expression:"userForm.nickname"}})],1),e._v(" "),t("el-form-item",{attrs:{prop:"password"}},[t("el-input",{attrs:{placeholder:"密码",type:"password"},model:{value:e.userForm.password,callback:function(r){e.$set(e.userForm,"password",r)},expression:"userForm.password"}})],1),e._v(" "),t("el-form-item",{staticClass:"me-login-button",attrs:{size:"small"}},[t("el-button",{attrs:{type:"primary"},nativeOn:{click:function(r){return r.preventDefault(),e.register("userForm")}}},[e._v("注册")])],1)],1)],1)])},staticRenderFns:[]};var a=t("VU/8")({name:"Register",data:function(){return{userForm:{account:"",nickname:"",password:""},rules:{account:[{required:!0,message:"请输入用户名",trigger:"blur"},{max:10,message:"不能大于10个字符",trigger:"blur"}],nickname:[{required:!0,message:"请输入昵称",trigger:"blur"},{max:10,message:"不能大于10个字符",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"},{max:10,message:"不能大于10个字符",trigger:"blur"}]}}},methods:{register:function(e){var r=this;this.$refs[e].validate(function(e){if(!e)return!1;r.$store.dispatch("register",r.userForm).then(function(){r.$message({message:"注册成功 快写文章吧",type:"success",showClose:!0}),r.$router.push({path:"/"})}).catch(function(e){"error"!==e&&r.$message({message:e,type:"error",showClose:!0})})})}}},s,!1,function(e){t("XJvi")},"data-v-64832b34",null);r.default=a.exports}});
//# sourceMappingURL=4.5c2b63919cda6f794d34.js.map