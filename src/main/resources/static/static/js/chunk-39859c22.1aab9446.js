(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-39859c22"],{"431d":function(e,t,a){"use strict";a("86a8")},"86a8":function(e,t,a){},c551:function(e,t,a){"use strict";a.d(t,"a",(function(){return r})),a.d(t,"d",(function(){return n})),a.d(t,"c",(function(){return l})),a.d(t,"b",(function(){return i})),a.d(t,"f",(function(){return c})),a.d(t,"e",(function(){return s}));var o=a("b775");function r(e){return Object(o["a"])({url:"/data-maintenance/add-college",method:"post",data:e})}function n(e){return Object(o["a"])({url:"/data-maintenance/add-organization",method:"post",data:e})}function l(e){return Object(o["a"])({url:"/data-maintenance/add-import-organization",method:"post",data:e})}function i(e){return Object(o["a"])({url:"/data-maintenance/add-import-majors",method:"post",data:e})}function c(){return Object(o["a"])({url:"/data-maintenance/get-organizations",method:"get"})}function s(){return Object(o["a"])({url:"/data-maintenance/get-majors",method:"get"})}},ddb9:function(e,t,a){"use strict";a.r(t);var o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-card",[a("div",{staticClass:"card-header",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("信息表导出")])]),a("div",[a("el-row",{staticStyle:{"margin-left":"22%","margin-bottom":"2%"}},[a("el-tag",[e._v("请选择导出范围(可按全校、年份、专业导出），省级优秀教学组织团队只能按年份导出或全校导出")])],1),a("el-row",{staticStyle:{"margin-left":"40%"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.exportType.value,callback:function(t){e.$set(e.exportType,"value",t)},expression:"exportType.value"}},e._l(e.exportType.options,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1),a("el-date-picker",{directives:[{name:"show",rawName:"v-show",value:e.isYearSelect,expression:"isYearSelect"}],attrs:{type:"year","value-format":"yyyy",placeholder:"选择年"},model:{value:e.yearSelect,callback:function(t){e.yearSelect=t},expression:"yearSelect"}}),a("el-autocomplete",{directives:[{name:"show",rawName:"v-show",value:e.isMajorSelect,expression:"isMajorSelect"}],staticClass:"inline-input",attrs:{"fetch-suggestions":e.querySearchInfo,placeholder:"请输入专业名称","trigger-on-focus":!1},on:{select:e.handleSelectInfo},model:{value:e.majorSelect,callback:function(t){e.majorSelect=t},expression:"majorSelect"}})],1),a("el-row",{staticStyle:{"margin-left":"32%","margin-top":"2%"}},[a("el-button",{staticStyle:{font:"14px Helvetica Neue,Helvetica,PingFang SC,Tahoma,Arial,sans-serif"},on:{click:e.exportBaseEducation}},[e._v("导出基层教学组织")]),a("el-button",{staticStyle:{font:"14x Helvetica Neue,Helvetica,PingFang SC,Tahoma,Arial,sans-serif"},on:{click:e.exportTeam}},[e._v("导出省级优秀基层教学组织团队")])],1)],1)])},r=[];a("a4d3"),a("e01a"),a("d3b7"),a("d28b"),a("3ca3"),a("ddb0"),a("fb6a"),a("b0c0"),a("a630");function n(e,t){(null==t||t>e.length)&&(t=e.length);for(var a=0,o=new Array(t);a<t;a++)o[a]=e[a];return o}function l(e,t){if(e){if("string"===typeof e)return n(e,t);var a=Object.prototype.toString.call(e).slice(8,-1);return"Object"===a&&e.constructor&&(a=e.constructor.name),"Map"===a||"Set"===a?Array.from(e):"Arguments"===a||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(a)?n(e,t):void 0}}function i(e,t){var a;if("undefined"===typeof Symbol||null==e[Symbol.iterator]){if(Array.isArray(e)||(a=l(e))||t&&e&&"number"===typeof e.length){a&&(e=a);var o=0,r=function(){};return{s:r,n:function(){return o>=e.length?{done:!0}:{done:!1,value:e[o++]}},e:function(e){throw e},f:r}}throw new TypeError("Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}var n,i=!0,c=!1;return{s:function(){a=e[Symbol.iterator]()},n:function(){var e=a.next();return i=e.done,e},e:function(e){c=!0,n=e},f:function(){try{i||null==a["return"]||a["return"]()}finally{if(c)throw n}}}}a("4de4"),a("d81d");var c=a("b775");function s(){return Object(c["a"])({url:"/export/all",method:"get"})}var u=a("c551"),f={data:function(){return{majors:[],form:[],exportType:{options:[{value:"college",label:"全校导出"},{value:"major",label:"按专业导出"},{value:"year",label:"按年份导出"}],value:""},yearSelect:"",isYearSelect:!1,majorSelect:"",isMajorSelect:!1,baseEducation:[],teamExcel:[],team:[]}},created:function(){this.getMajors(),this.getAll()},methods:{getMajors:function(){var e=this;Object(u["e"])().then((function(t){console.log(t);for(var a=0;a<t.data.length;a++){var o={};o.value=t.data[a].nameOfTheMajorInTheSchool,console.log(t.data[a]),e.majors.push(o)}})).catch((function(e){console.log(e)}))},handleSelectInfo:function(e){console.log(e)},querySearchInfo:function(e,t){var a=this.majors,o=e?a.filter(this.createFilterInfo(e)):a;t(o)},createFilterInfo:function(e){return function(t){return-1!==t.value.toLowerCase().indexOf(e.toLowerCase())}},getAll:function(){var e=this;s().then((function(t){e.form=t.data,console.log(e.form),console.log(e.team)})).catch((function(e){console.log(e)}))},exportBaseEducation:function(){var e=0;e=0==this.isMajorSelect&&0==this.isYearSelect?0:1==this.isMajorSelect?1:2,console.log(e);var t,a=i(this.form);try{for(a.s();!(t=a.n()).done;){var o=t.value;if(2!==e||(console.log(o.createYear),console.log(this.yearSelect),o.createYear==this.yearSelect)){var r,n=i(o.faceSchoolMajors);try{for(n.s();!(r=n.n()).done;){var l=r.value;if(1!==e||l.schoolOrientedProfessionalTitles==this.majorSelect){console.log(o.faceSchoolMajors);var c={};c.organization=o.organization,c.type=o.type,c.level=o.level,c.createYear=o.createYear,c.principal=o.principal,c.principalNumber=o.principalNumber,c.faceMultiple=o.faceMultiple,c.schoolOrientedProfessionalTitles=l.schoolOrientedProfessionalTitles,c.schoolOrientedProfessionalTitlesCode=l.schoolOrientedProfessionalTitlesCode,c.schoolOrientedProfessionalTitlesProporation=l.schoolOrientedProfessionalTitlesProporation,this.baseEducation.push(c),console.log(c)}}}catch(s){n.e(s)}finally{n.f()}}}}catch(s){a.e(s)}finally{a.f()}this.exportToExcel()},exportTeam:function(){var e=0;e=0==this.isMajorSelect&&0==this.isYearSelect?0:1==this.isMajorSelect?1:2,console.log(e);var t,a=i(this.form);try{for(a.s();!(t=a.n()).done;){var o=t.value;if(2!=e||o.getTime==this.yearSelect){var r,n=i(o.teacher);try{for(n.s();!(r=n.n()).done;){var l=r.value,c={};c.teacherNumber=l.teacherNumber,c.teacherName=l.teacherName,c.isPrincipal=l.isPrincipal,c.teamName=o.teamName,c.baseEducationType=o.baseEducationType,c.teamType=o.teamType,c.getTime=o.getTime,c.teamLevel=o.teamLevel,c.awardDepartment=o.awardDepartment,this.teamExcel.push(c),console.log(c)}}catch(s){n.e(s)}finally{n.f()}}}}catch(s){a.e(s)}finally{a.f()}this.exportTeamToExcel()},exportToExcel:function(){var e=this;Promise.all([a.e("chunk-519483dc"),a.e("chunk-31056cfb"),a.e("chunk-6fde8a01")]).then(function(){var t=a("8530"),o=t.export_json_to_excel,r=["基层教学组织名称","基层教学组织类型","基层教学组织级别","设立时间","负责人姓名","负责人工号","面向校内专业个数","面向校内专业（大类）名称","面向校内专业（大类）代码","面向专业的比例"],n=["organization","type","level","createYear","principal","principalNumber","faceMultiple","schoolOrientedProfessionalTitles","schoolOrientedProfessionalTitlesCode","schoolOrientedProfessionalTitlesProporation"],l=e.baseEducation,i=e.formatJson(n,l);o(r,i,"基层教学组织表"),e.baseEducation=[]}.bind(null,a)).catch(a.oe)},exportTeamToExcel:function(){var e=this;Promise.all([a.e("chunk-519483dc"),a.e("chunk-31056cfb"),a.e("chunk-6fde8a01")]).then(function(){var t=a("8530"),o=t.export_json_to_excel,r=["教师工号","教师姓名","是否团队负责人","团队名称","类型","类别","获得时间","等级","授予部门"],n=["teacherNumber","teacherName","isPrincipal","teamName","baseEducationType","teamType","getTime","teamLevel","awardDepartment"],l=e.teamExcel,i=e.formatJson(n,l);o(r,i,"优秀基层教学组织团队表"),e.teamExcel=[]}.bind(null,a)).catch(a.oe)},formatJson:function(e,t){return t.map((function(t){return e.map((function(e){return t[e]}))}))}},watch:{"exportType.value":function(){"college"===this.exportType.value&&(this.isMajorSelect=!1,this.isYearSelect=!1),"major"===this.exportType.value&&(this.isMajorSelect=!0,this.isYearSelect=!1),"year"===this.exportType.value&&(this.isYearSelect=!0,this.isMajorSelect=!1)}}},d=f,h=(a("431d"),a("2877")),m=Object(h["a"])(d,o,r,!1,null,"1f7c08cf",null);t["default"]=m.exports}}]);