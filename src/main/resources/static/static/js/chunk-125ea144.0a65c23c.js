(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-125ea144"],{4250:function(e,t,o){"use strict";o("9ed0")},"9ed0":function(e,t,o){},c551:function(e,t,o){"use strict";o.d(t,"a",(function(){return r})),o.d(t,"d",(function(){return n})),o.d(t,"c",(function(){return l})),o.d(t,"b",(function(){return i})),o.d(t,"f",(function(){return c})),o.d(t,"e",(function(){return s}));var a=o("b775");function r(e){return Object(a["a"])({url:"/data-maintenance/add-college",method:"post",data:e})}function n(e){return Object(a["a"])({url:"/data-maintenance/add-organization",method:"post",data:e})}function l(e){return Object(a["a"])({url:"/data-maintenance/add-import-organization",method:"post",data:e})}function i(e){return Object(a["a"])({url:"/data-maintenance/add-import-majors",method:"post",data:e})}function c(){return Object(a["a"])({url:"/data-maintenance/get-organizations",method:"get"})}function s(){return Object(a["a"])({url:"/data-maintenance/get-majors",method:"get"})}},ddb9:function(e,t,o){"use strict";o.r(t);var a=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("el-card",[o("div",{staticClass:"card-header",attrs:{slot:"header"},slot:"header"},[o("span",[e._v("备案表导出")])]),o("div",[o("el-row",{staticStyle:{"margin-left":"41.5%","margin-bottom":"2%"}},[o("el-tag",{attrs:{type:""}},[e._v("请选择导出范围")])],1),o("el-row",{staticStyle:{"margin-left":"40%"}},[o("el-select",{attrs:{placeholder:"请选择"},model:{value:e.exportType.value,callback:function(t){e.$set(e.exportType,"value",t)},expression:"exportType.value"}},e._l(e.exportType.options,(function(e){return o("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1),o("el-date-picker",{directives:[{name:"show",rawName:"v-show",value:e.isYearSelect,expression:"isYearSelect"}],attrs:{type:"year","value-format":"yyyy",placeholder:"选择年"},model:{value:e.yearSelect,callback:function(t){e.yearSelect=t},expression:"yearSelect"}}),o("el-autocomplete",{directives:[{name:"show",rawName:"v-show",value:e.isMajorSelect,expression:"isMajorSelect"}],staticClass:"inline-input",attrs:{"fetch-suggestions":e.querySearchInfo,placeholder:"请输入专业名称","trigger-on-focus":!1},on:{select:e.handleSelectInfo},model:{value:e.majorSelect,callback:function(t){e.majorSelect=t},expression:"majorSelect"}})],1),o("el-row",{staticStyle:{"margin-left":"42%","margin-top":"2%"}},[o("el-button",{on:{click:e.exportBaseEducation}},[e._v("导出基层教学组织")])],1)],1)])},r=[];o("a4d3"),o("e01a"),o("d3b7"),o("d28b"),o("3ca3"),o("ddb0"),o("fb6a"),o("b0c0"),o("a630");function n(e,t){(null==t||t>e.length)&&(t=e.length);for(var o=0,a=new Array(t);o<t;o++)a[o]=e[o];return a}function l(e,t){if(e){if("string"===typeof e)return n(e,t);var o=Object.prototype.toString.call(e).slice(8,-1);return"Object"===o&&e.constructor&&(o=e.constructor.name),"Map"===o||"Set"===o?Array.from(e):"Arguments"===o||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o)?n(e,t):void 0}}function i(e,t){var o;if("undefined"===typeof Symbol||null==e[Symbol.iterator]){if(Array.isArray(e)||(o=l(e))||t&&e&&"number"===typeof e.length){o&&(e=o);var a=0,r=function(){};return{s:r,n:function(){return a>=e.length?{done:!0}:{done:!1,value:e[a++]}},e:function(e){throw e},f:r}}throw new TypeError("Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}var n,i=!0,c=!1;return{s:function(){o=e[Symbol.iterator]()},n:function(){var e=o.next();return i=e.done,e},e:function(e){c=!0,n=e},f:function(){try{i||null==o["return"]||o["return"]()}finally{if(c)throw n}}}}o("4de4"),o("d81d");var c=o("b775");function s(){return Object(c["a"])({url:"/export/all",method:"get"})}var u=o("c551"),f={data:function(){return{majors:[],form:[],exportType:{options:[{value:"college",label:"全校导出"},{value:"major",label:"按专业导出"},{value:"year",label:"按年份导出"}],value:""},yearSelect:"",isYearSelect:!1,majorSelect:"",isMajorSelect:!1,baseEducation:[]}},created:function(){this.getMajors(),this.getAllBaseEducationForm()},methods:{getMajors:function(){var e=this;Object(u["e"])().then((function(t){console.log(t);for(var o=0;o<t.data.length;o++){var a={};a.value=t.data[o].nameOfTheMajorInTheSchool,console.log(t.data[o]),e.majors.push(a)}})).catch((function(e){console.log(e)}))},handleSelectInfo:function(e){console.log(e)},querySearchInfo:function(e,t){var o=this.majors,a=e?o.filter(this.createFilterInfo(e)):o;t(a)},createFilterInfo:function(e){return function(t){return-1!==t.value.toLowerCase().indexOf(e.toLowerCase())}},getAllBaseEducationForm:function(){var e=this;s().then((function(t){e.form=t.data,console.log(e.form)})).catch((function(e){console.log(e)}))},exportBaseEducation:function(){var e=0;e=0==this.isMajorSelect&&0==this.isYearSelect?0:1==this.isMajorSelect?1:2,console.log(e);var t,o=i(this.form);try{for(o.s();!(t=o.n()).done;){var a=t.value;if(2!==e||(console.log(a.createYear),console.log(this.yearSelect),a.createYear===this.yearSelect)){var r,n=i(a.faceSchoolMajors);try{for(n.s();!(r=n.n()).done;){var l=r.value;if(1!==e||l.schoolOrientedProfessionalTitles==this.majorSelect){console.log(a.faceSchoolMajors);var c={};c.organization=a.organization,c.type=a.type,c.level=a.level,c.createYear=a.createYear,c.principal=a.principal,c.principalNumber=a.principalNumber,c.faceMultiple=a.faceMultiple,c.schoolOrientedProfessionalTitles=l.schoolOrientedProfessionalTitles,c.schoolOrientedProfessionalTitlesCode=l.schoolOrientedProfessionalTitlesCode,c.schoolOrientedProfessionalTitlesProporation=l.schoolOrientedProfessionalTitlesProporation,this.baseEducation.push(c),console.log(c)}}}catch(s){n.e(s)}finally{n.f()}}}}catch(s){o.e(s)}finally{o.f()}this.exportToExcel()},exportToExcel:function(){var e=this;Promise.all([o.e("chunk-519483dc"),o.e("chunk-31056cfb"),o.e("chunk-6fde8a01")]).then(function(){var t=o("8530"),a=t.export_json_to_excel,r=["基层教学组织名称","基层教学组织类型","基层教学组织级别","设立时间","负责人姓名","负责人工号","面向校内专业个数","面向校内专业（大类）名称","面向校内专业（大类）代码","面向专业的比例"],n=["organization","type","level","createYear","principal","principalNumber","faceMultiple","schoolOrientedProfessionalTitles","schoolOrientedProfessionalTitlesCode","schoolOrientedProfessionalTitlesProportion"],l=e.baseEducation,i=e.formatJson(n,l);a(r,i,"基层教学组织表")}.bind(null,o)).catch(o.oe)},formatJson:function(e,t){return t.map((function(t){return e.map((function(e){return t[e]}))}))}},watch:{"exportType.value":function(){"college"===this.exportType.value&&(this.isMajorSelect=!1,this.isYearSelect=!1),"major"===this.exportType.value&&(this.isMajorSelect=!0,this.isYearSelect=!1),"year"===this.exportType.value&&(this.isYearSelect=!0,this.isMajorSelect=!1)}}},d=f,h=(o("4250"),o("2877")),p=Object(h["a"])(d,a,r,!1,null,"5f876ef4",null);t["default"]=p.exports}}]);