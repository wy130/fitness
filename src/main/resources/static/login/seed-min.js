/*
Copyright 2014, KISSY v1.44
MIT Licensed
build time: Jun 10 15:14
*/
var KISSY=function(a) {
    function f(a){var g={
},f;for(f in j)(function(b,d) {
    b[d]=function(b){return h.log(b,d,a)
}})(g,f);return g
}

var h,k=0,j= {
debug: 10,info:20,warn:30,error:40
};

h= {
__BUILD_TIME: "20140610151400",Env:{host:this
},Config: {
debug: "",fns:{
}},version:"1.44",config:function(c,g) {
var f,b,d=this,i,e=h.Config,o=e.fns;h.isObject(c)?h.each(c,function(a,b){(i=o[b])?i.call(d,a): e[b]=a
}):(f=o[c],g===a?b=f?f.call(d):e[c]:f?b=f.call(d,g):e[c]=g);return b
},log:function() {
return a
},getLogger:function(a) {
return f(a)
},
error:function() {
},guid:function(a) {
return(a||"")+k++
},Logger: {
}};

h.Logger.Level= {
DEBUG: "debug",INFO:"info",WARN:"warn",ERROR:"error"
};

return h
}();
(function(a,f) {
function h(){
}

function k(d,l,b,e,i,g) {
if(!l||!d)return d;var r,q,u,x;l[c]=d;g.push(l);u=a.keys(l);x=u.length;for(r=0;r<x;r++)if(q=u[r],q!==c){var h=d,j=l,w=b,F=e,H=i,K=g;if(w||!(q in h)||H){var y=h[q],v=j[q];if(y===v)y===f&&(h[q]=y);else if(F&&(v=F.call(j,q,v)),H&&v&&(a.isArray(v)||a.isPlainObject(v)))v[c]?h[q]=v[c]: (j=y&&(a.isArray(y)||a.isPlainObject(y))?y:a.isArray(v)?[]:{
},h[q]=j,k(j,v,w,F,n,K));else if(v!==f&&(w||!(q in h)))h[q]=v
}}

return d
}

function j(a,d) {
return"constructor"===
a?f: d
}

var c="__MIX_CIRCULAR",g=this,n=!0,b=Object,d=b.create,i=! {
toString: 1
}

.propertyIsEnumerable("toString"),e="constructor,hasOwnProperty,isPrototypeOf,propertyIsEnumerable,toString,toLocaleString,valueOf".split(",");(function(a,d) {
for(var b in d)a[b]=d[b]
})(a, {
stamp: function(d,b,e){var e=e||"__~ks_stamped",c=d[e];
if(!c&&!b)try{c=d[e]=a.guid(e)
}

catch(i) {
c=f
}

return c
},keys:b.keys||function(a) {
var d=[],b,c;for(b in a)a.hasOwnProperty(b)&&d.push(b);if(i)for(c=e.length-1;0<=c;c--)b=e[c],a.hasOwnProperty(b)&&
d.push(b);return d
},mix:function(d,b,e,i,s) {
"object"
===typeof e&&(i=e.whitelist,s=e.deep,e=e.overwrite);if(i&&"function"!==typeof i)var g=i,i=function(d,b){return a.inArray(d,g)?b: f
};

e===f&&(e=n);var r=[],q=0;for(k(d,b,e,i,s,r);b=r[q++];)delete b[c];return d
},merge:function(d) {
var d=a.makeArray(arguments),b={
},e,c=d.length;for(e=0;e<c;e++)a.mix(b,d[e]);return b
},augment:function(d,b) {
var e=a.makeArray(arguments),c=e.length-2,i=1,g,r,q=e[c],u=e[c+1];e[1]=b;a.isArray(u)||(q=u,u=f,c++);"boolean"!==typeof q&&
(q=f,c++);for(;i<c;i++){r=e[i];if(g=r.prototype)r=a.mix({
},g,!0,j);a.mix(d.prototype,r,q,u)
}

return d
},extend:function(b,l,e,c) {
var i=l.prototype;i.constructor=l;d?l=d(i): (h.prototype=i,l=new h);
l.constructor=b;b.prototype=a.mix(l,b.prototype);b.superclass=i;e&&a.mix(l,e);c&&a.mix(b,c);return b
},namespace:function() {
var d=a.makeArray(arguments),b=d.length,e=null,c,i,f,r=d[b-1]===n&&b--;for(c=0;c<b;c++){f=(""+d[c]).split(".");e=r?g: this;
for(i=g[f[0]]===e?1: 0;
i<f.length;++i)e=e[f[i]]=e[f[i]]||{
}}

return e
}})})(KISSY);
(function(a,f) {
var h=Array.prototype,k=h.indexOf,j=h.lastIndexOf,c=h.filter,g=h.every,n=h.some,b=h.map;a.mix(a,{each: function(d,b,e){if(d){var c,l,m=0;
c=d&&d.length;l=c===f||"function"===a.type(d);e=e||null;if(l)for(l=a.keys(d);m<l.length&&!(c=l[m],!1===b.call(e,d[c],c,d));m++);else for(l=d[0];m<c&&!1!==b.call(e,l,m,d);l=d[++m]);
}

return d
},indexOf:k?function(a,b) {
return k.call(b,a)
}

:function(a,b) {
for(var e=0,c=b.length;e<c;++e)if(b[e]===a)return e;return-1
},lastIndexOf:j?function(a,b) {
return j.call(b,
a)
}

:function(a,b) {
for(var e=b.length-1;0<=e&&b[e]!==a;e--);return e
},unique:function(b,c) {
var e=b.slice();c&&e.reverse();for(var o=0,l,m;o<e.length;){for(m=e[o];(l=a.lastIndexOf(m,e))!==o;)e.splice(l,1);o+=1
}

c&&e.reverse();return e
},inArray:function(b,c) {
return-1<a.indexOf(b,c)
},filter:c?function(a,b,e) {
return c.call(a,b,e||this)
}

:function(b,c,e) {
var o=[];a.each(b,function(a,b,d){c.call(e||this,a,b,d)&&o.push(a)
});

return o
},map:b?function(a,c,e) {
return b.call(a,c,e||this)
}

:function(a,b,e) {
for(var c=
a.length,l=Array(c),m=0;m<c;m++){var f="string"===typeof a?a.charAt(m): a[m];
if(f||m in a)l[m]=b.call(e||this,f,m,a)
}

return l
},reduce:function(a,b,e) {
var c=a.length;if("function"!==typeof b)throw new TypeError("callback is not function!");if(0===c&&2===arguments.length)throw new TypeError("arguments invalid");var l=0,m;if(3<=arguments.length)m=e;else{do{if(l in a){m=a[l++];break
}

l+=1;if(l>=c)throw new TypeError;
}

while(1)
}

for(;l<c;)l in a&&(m=b.call(f,m,a[l],l,a)),l++;return m
},every:g?function(a,b,
e) {
return g.call(a,b,e||this)
}

:function(a,b,e) {
for(var c=a&&a.length||0,l=0;l<c;l++)if(l in a&&!b.call(e,a[l],l,a))return!1;return!0
},some:n?function(a,b,c) {
return n.call(a,b,c||this)
}

:function(a,b,c) {
for(var o=a&&a.length||0,l=0;l<o;l++)if(l in a&&b.call(c,a[l],l,a))return!0;return!1
},makeArray:function(b) {
if(null==b)return[];if(a.isArray(b))return b;var c=typeof b.length,e=typeof b;if("number"!==c||b.alert||"string"===e||"function"===e&&!("item"in b&&"number"===c))return[b];for(var c=[],e=0,o=b.length;e<
o;e++)c[e]=b[e];return c
}})})(KISSY);
(function(a,f) {
function h(a){var b=typeof a;return null==a||"object"!==b&&"function"!==b
}

function k() {
if(b)return b;var d=c;a.each(g,function(a){d+=a+"|"
});

d=d.slice(0,-1);return b=RegExp(d,"g")
}

function j() {
if(d)return d;var b=c;a.each(n,function(a){b+=a+"|"
});

b+="&#(\\d{1,5});";return d=RegExp(b,"g")
}

var c="",g= {
"&amp;"
:"&","&gt;": ">","&lt;":"<","&#x60;":"`","&#x2F;":"/","&quot;":'"',"&#x27;":"'"
},n= {
},b,d,i=/[\-#$\^*()+\[\] {
}|\\,.?\s]/g;(function() {
for(var a in g)n[g[a]]=a
})();

a.mix(a, {
urlEncode: function(a){return encodeURIComponent(""+
a)
},urlDecode:function(a) {
return decodeURIComponent(a.replace(/\+/g," "))
},fromUnicode:function(a) {
return a.replace(/\\u([a-f\d]{4
})/ig,function(a,b) {
return String.fromCharCode(parseInt(b,16))
})},escapeHtml:function(a) {
return(a+"").replace(k(),function(a){return n[a]
})},escapeRegExp:function(a) {
return a.replace(i,"\\$&")
},unEscapeHtml:function(a) {
return a.replace(j(),function(a,b){return g[a]||String.fromCharCode(+b)
})},param:function(b,d,l,m) {
d=d||"&";l=l||"=";m===f&&(m=!0);var i=[],g,j,r,q,u,x=
a.urlEncode;for(g in b)if(u=b[g],g=x(g),h(u))i.push(g),u!==f&&i.push(l,x(u+c)),i.push(d);else if(a.isArray(u)&&u.length){j=0;for(q=u.length;j<q;++j)r=u[j],h(r)&&(i.push(g,m?x("[]"): c),r!==f&&i.push(l,x(r+c)),i.push(d))
}

i.pop();return i.join(c)
},unparam:function(b,d,c) {
if("string"!==typeof b||!(b=a.trim(b)))return{
};

for(var c=c||"=",m= {
},i,g=a.urlDecode,b=b.split(d||"&"),h=0,r=b.length;h<r;++h) {
i=b[h].indexOf(c);if(-1===i)d=g(b[h]),i=f;else{d=g(b[h].substring(0,i));i=b[h].substring(i+1);try{i=g(i)
}

catch(q) {
}

a.endsWith(d,
"[]")&&(d=d.substring(0,d.length-2))
}

d in m?a.isArray(m[d])?m[d].push(i):m[d]=[m[d],i]:m[d]=i
}

return m
}});

a.escapeHTML=a.escapeHtml;a.unEscapeHTML=a.unEscapeHtml
})(KISSY);
(function(a) {
function f(a,f,j){function c(){
}

var g=[].slice,n=g.call(arguments,3),b=function() {
var b=g.call(arguments);return f.apply(this instanceof c?this: j||this,a?b.concat(n):n.concat(b))
};

c.prototype=f.prototype;b.prototype=new c;return b
}

a.mix(a, {
noop: function(){
},bind:f(0,f,null,0),rbind:f(0,f,null,1),later:function(f,k,j,c,g) {
var k=k||0,n=f,b=a.makeArray(g),d;"string"===typeof f&&(n=c[f]);f=function(){n.apply(c,b)
};

d=j?setInterval(f,k):setTimeout(f,k);return {
id: d,interval:j,cancel:function(){this.interval?
clearInterval(d):clearTimeout(d)
}}},throttle:function(f,k,j) {
k=k||150;if(-1===k)return function(){f.apply(j||this,arguments)
};

var c=a.now();return function() {
var g=a.now();g-c>k&&(c=g,f.apply(j||this,arguments))
}},buffer:function(f,k,j) {
function c(){c.stop();g=a.later(f,k,0,j||this,arguments)
}

k=k||150;if(-1===k)return function() {
f.apply(j||this,arguments)
};

var g=null;c.stop=function() {
g&&(g.cancel(),g=0)
};

return c
}})})(KISSY);
(function(a,f) {
function h(b,d,i){var e=b,f,l,m,j;if(!b)return e;if(b[g])return i[b[g]].destination;if("object"===typeof b){j=b.constructor;if(a.inArray(j,[Boolean,String,Number,Date,RegExp]))e=new j(b.valueOf());else if(f=a.isArray(b))e=d?a.filter(b,d): b.concat();
else if(l=a.isPlainObject(b))e={
};

b[g]=j=a.guid("c");i[j]= {
destination: e,input:b
}}

if(f)for(b=0;b<e.length;b++)e[b]=h(e[b],d,i);else if(l)for(m in b)if(m!==g&&(!d||d.call(b,b[m],m,b)!==c))e[m]=h(b[m],d,i);return e
}

function k(b,d,c,e) {
if(b[n]===
d&&d[n]===b)return j;b[n]=d;d[n]=b;var g=function(a,b){return null!==a&&a!==f&&a[b]!==f
},l;for(l in d)!g(b,l)&&g(d,l)&&c.push("expected has key "+l+'", but missing from actual.');for(l in b)!g(d,l)&&g(b,l)&&c.push('expected missing key "'+l+'", but present in actual.');for(l in d)l!==n&&(a.equals(b[l],d[l],c,e)||e.push('"'+l+'" was "'+(d[l]?d[l].toString():d[l])+'" in expected, but was "'+(b[l]?b[l].toString():b[l])+'" in actual.'));a.isArray(b)&&a.isArray(d)&&b.length!==d.length&&e.push("arrays were not the same length");
delete b[n];delete d[n];return 0===c.length&&0===e.length
}

var j=!0,c=!1,g="__~ks_cloned",n="__~ks_compared";a.mix(a, {
equals: function(a,d,c,e){c=c||[];
e=e||[];return a===d?j: a===f||null===a||d===f||null===d?null==a&&null==d:a instanceof Date&&d instanceof Date?a.getTime()===d.getTime():"string"===typeof a&&"string"===typeof d||"number"===typeof a&&"number"===typeof d?a===d:"object"===typeof a&&"object"===typeof d?k(a,d,c,e):a===d
},clone:function(b,d) {
var c={
},e=h(b,d,c);a.each(c,function(a) {
a=a.input;
if(a[g])try{delete a[g]
}

catch(b) {
a[g]=f
}});

c=null;return e
},now:Date.now||function() {
return+new Date
}})})(KISSY);
(function(a,f) {
var h=/^[\s\xa0]+|[\s\xa0]+$/g,k=String.prototype.trim,j=/\\?\{([^{
}]+)\}/g;a.mix(a, {
trim: k?function(a){return null==a?"":k.call(a)
}

:function(a) {
return null==a?"": (a+"").replace(h,"")
},substitute:function(a,g,h) {
return"string"!==typeof a||!g?a: a.replace(h||j,function(a,d){return"\\"===a.charAt(0)?a.slice(1):g[d]===f?"":g[d]})},ucfirst:function(a){a+="";return a.charAt(0).toUpperCase()+a.substring(1)},startsWith:function(a,f){return 0===a.lastIndexOf(f,0)},endsWith:function(a,f){var j=
a.length-f.length;return 0<=j&&a.indexOf(f,j)===j}})})(KISSY);
(function(a,f){var h={},k=Object.prototype,j=k.toString;a.mix(a,{type:function(a){return null==a?""+a:h[j.call(a)]||"object"},isNull:function(a){return null===a},isUndefined:function(a){return a===f},isEmptyObject:function(a){for(var g in a)if(g!==f)return!1;return!0},isPlainObject:function(c){if(!c||"object"!==a.type(c)||c.nodeType||c.window==c)return!1;var g,j;try{if((j=c.constructor)&&!k.hasOwnProperty.call(c,"constructor")&&!k.hasOwnProperty.call(j.prototype,"isPrototypeOf"))return!1}catch(b){return!1}for(g in c);
return g===f||k.hasOwnProperty.call(c,g)}});a.each("Boolean,Number,String,Function,Date,RegExp,Object,Array".split(","),function(c,f){h["[object "+c+"]"]=f=c.toLowerCase();a["is"+c]=function(c){return a.type(c)===f}});a.isArray=Array.isArray||a.isArray})(KISSY);
(function(a){function f(){for(var a=0,b;b=h[a++];)try{b()}catch(d){setTimeout(function(){throw d;},0)}1<a&&(h=[]);k=0}var h=[],k=0;a.setImmediate=function(a){h.push(a);k||(k=1,j())};var j;if("function"===typeof setImmediate)j=function(){setImmediate(f)};else if("undefined"!==typeof process&&"function"===typeof process.nextTick)j=function(){process.nextTick(f)};else if("undefined"!==typeof MessageChannel){var c=new MessageChannel;c.port1.onmessage=function(){j=g;c.port1.onmessage=f;f()};var g=function(){c.port2.postMessage(0)};
j=function(){setTimeout(f,0);g()}}else j=function(){setTimeout(f,0)}})(KISSY);
(function(a){function f(a,c){for(var f=0,h=a.length-1,b=[],d;0<=h;h--)d=a[h],"."!==d&&(".."===d?f++:f?f--:b[b.length]=d);if(c)for(;f--;f)b[b.length]="..";return b=b.reverse()}var h=/^(\/?)([\s\S]+\/(?!$)|\/)?((?:\.{1,2}$|[\s\S]+?)?(\.[^.\/]*)?)$/,k=a.Path={resolve:function(){var j="",c,g=arguments,h,b=0;for(c=g.length-1;0<=c&&!b;c--)h=g[c],"string"===typeof h&&h&&(j=h+"/"+j,b="/"===h.charAt(0));j=f(a.filter(j.split("/"),function(a){return!!a}),!b).join("/");return(b?"/":"")+j||"."},normalize:function(j){var c=
"/"===j.charAt(0),g="/"===j.slice(-1),j=f(a.filter(j.split("/"),function(a){return!!a}),!c).join("/");!j&&!c&&(j=".");j&&g&&(j+="/");return(c?"/":"")+j},join:function(){var f=a.makeArray(arguments);return k.normalize(a.filter(f,function(a){return a&&"string"===typeof a}).join("/"))},relative:function(f,c){var f=k.normalize(f),c=k.normalize(c),g=a.filter(f.split("/"),function(a){return!!a}),h=[],b,d,i=a.filter(c.split("/"),function(a){return!!a});d=Math.min(g.length,i.length);for(b=0;b<d&&g[b]===i[b];b++);
for(d=b;b<g.length;)h.push(".."),b++;h=h.concat(i.slice(d));return h=h.join("/")},basename:function(a,c){var f;f=(a.match(h)||[])[3]||"";c&&f&&f.slice(-1*c.length)===c&&(f=f.slice(0,-1*c.length));return f},dirname:function(a){var c=a.match(h)||[],a=c[1]||"",c=c[2]||"";if(!a&&!c)return".";c&&(c=c.substring(0,c.length-1));return a+c},extname:function(a){return(a.match(h)||[])[4]||""}}})(KISSY);
(function(a,f){function h(b){b._queryMap||(b._queryMap=a.unparam(b._query))}function k(a){this._query=a||""}function j(a,b){return encodeURI(a).replace(b,function(a){a=a.charCodeAt(0).toString(16);return"%"+(1===a.length?"0"+a:a)})}function c(b){if(b instanceof c)return b.clone();var d=this;a.mix(d,{scheme:"",userInfo:"",hostname:"",port:"",path:"",query:"",fragment:""});b=c.getComponents(b);a.each(b,function(b,c){b=b||"";if("query"===c)d.query=new k(b);else{try{b=a.urlDecode(b)}catch(l){}d[c]=b}});
return d}var g=/[#\/\?@]/g,n=/[#\?]/g,b=/[#@]/g,d=/#/g,i=RegExp("^(?:([\\w\\d+.-]+):)?(?://(?:([^/?#@]*)@)?([\\w\\d\\-\\u0100-\\uffff.+%]*|\\[[^\\]]+\\])(?::([0-9]+))?)?([^?#]+)?(?:\\?([^#]*))?(?:#(.*))?$"),e=a.Path,o={scheme:1,userInfo:2,hostname:3,port:4,path:5,query:6,fragment:7};k.prototype={constructor:k,clone:function(){return new k(this.toString())},reset:function(a){this._query=a||"";this._queryMap=null;return this},count:function(){var b=0,d,c;h(this);d=this._queryMap;for(c in d)a.isArray(d[c])?
b+=d[c].length:b++;return b},has:function(b){var d;h(this);d=this._queryMap;return b?b in d:!a.isEmptyObject(d)},get:function(a){var b;h(this);b=this._queryMap;return a?b[a]:b},keys:function(){h(this);return a.keys(this._queryMap)},set:function(b,d){var c;h(this);c=this._queryMap;"string"===typeof b?this._queryMap[b]=d:(b instanceof k&&(b=b.get()),a.each(b,function(a,b){c[b]=a}));return this},remove:function(a){h(this);a?delete this._queryMap[a]:this._queryMap={};return this},add:function(a,b){var d,
c;if("string"===typeof a)h(this),d=this._queryMap,c=d[a],c=c===f?b:[].concat(c).concat(b),d[a]=c;else for(d in a instanceof k&&(a=a.get()),a)this.add(d,a[d]);return this},toString:function(b){h(this);return a.param(this._queryMap,f,f,b)}};c.prototype={constructor:c,clone:function(){var b=new c,d=this;a.each(o,function(a,c){b[c]=d[c]});b.query=b.query.clone();return b},resolve:function(b){"string"===typeof b&&(b=new c(b));var d=0,f,i=this.clone();a.each("scheme,userInfo,hostname,port,path,query,fragment".split(","),
function(c){if(c==="path")if(d)i[c]=b[c];else{if(c=b.path){d=1;if(!a.startsWith(c,"/"))if(i.hostname&&!i.path)c="/"+c;else if(i.path){f=i.path.lastIndexOf("/");f!==-1&&(c=i.path.slice(0,f+1)+c)}i.path=e.normalize(c)}}else if(c==="query"){if(d||b.query.toString()){i.query=b.query.clone();d=1}}else if(d||b[c]){i[c]=b[c];d=1}});return i},getScheme:function(){return this.scheme},setScheme:function(a){this.scheme=a;return this},getHostname:function(){return this.hostname},setHostname:function(a){this.hostname=
a;return this},setUserInfo:function(a){this.userInfo=a;return this},getUserInfo:function(){return this.userInfo},setPort:function(a){this.port=a;return this},getPort:function(){return this.port},setPath:function(a){this.path=a;return this},getPath:function(){return this.path},setQuery:function(d){"string"===typeof d&&(a.startsWith(d,"?")&&(d=d.slice(1)),d=new k(j(d,b)));this.query=d;return this},getQuery:function(){return this.query},getFragment:function(){return this.fragment},setFragment:function(b){a.startsWith(b,
"#")&&(b=b.slice(1));this.fragment=b;return this},isSameOriginAs:function(a){return this.hostname.toLowerCase()===a.hostname.toLowerCase()&&this.scheme.toLowerCase()===a.scheme.toLowerCase()&&this.port.toLowerCase()===a.port.toLowerCase()},toString:function(b){var c=[],f,i;if(f=this.scheme)c.push(j(f,g)),c.push(":");if(f=this.hostname){c.push("//");if(i=this.userInfo)c.push(j(i,g)),c.push("@");c.push(encodeURIComponent(f));if(i=this.port)c.push(":"),c.push(i)}if(i=this.path)f&&!a.startsWith(i,"/")&&
(i="/"+i),i=e.normalize(i),c.push(j(i,n));if(b=this.query.toString.call(this.query,b))c.push("?"),c.push(b);if(b=this.fragment)c.push("#"),c.push(j(b,d));return c.join("")}};c.Query=k;c.getComponents=function(b){var d=(b||"").match(i)||[],c={};a.each(o,function(a,b){c[b]=d[a]});return c};a.Uri=c})(KISSY);
(function(a,f){function h(a){var b=0;return parseFloat(a.replace(/\./g,function(){return 0===b++?".":""}))}function k(a,b){var d;b.trident=0.1;if((d=a.match(/Trident\/([\d.]*)/))&&d[1])b.trident=h(d[1]);b.core="trident"}function j(a){var b,d;return(b=a.match(/MSIE ([^;]*)|Trident.*; rv(?:\s|:)?([0-9.]+)/))&&(d=b[1]||b[2])?h(d):0}function c(a){var b,d="",c="",e,i=[6,9],r,q=n&&n.createElement("div"),u=[],g={webkit:f,trident:f,gecko:f,presto:f,chrome:f,safari:f,firefox:f,ie:f,ieMode:f,opera:f,mobile:f,
core:f,shell:f,phantomjs:f,os:f,ipad:f,iphone:f,ipod:f,ios:f,android:f,nodejs:f};q&&q.getElementsByTagName&&(q.innerHTML="<\!--[if IE {{version
}}]><s></s><![endif]--\>".replace(" {
{version
}}",""),u=q.getElementsByTagName("s"));if(0<u.length){k(a,g);e=i[0];for(i=i[1];e<=i;e++)if(q.innerHTML="<\!--[if IE {
{version
}}]><s></s><![endif]--\>".replace(" {
{version
}}",e),0<u.length){g[c="ie"]=e;break}if(!g.ie&&(r=j(a)))g[c="ie"]=r}else if((e=a.match(/AppleWebKit\/([\d.]*)/))&&e[1]){g[d="webkit"]=h(e[1]);if((e=
a.match(/OPR\/(\d+\.\d+)/))&&e[1])g[c="opera"]=h(e[1]);else if((e=a.match(/Chrome\/([\d.]*)/))&&e[1])g[c="chrome"]=h(e[1]);else if((e=a.match(/\/([\d.]*) Safari/))&&e[1])g[c="safari"]=h(e[1]);if(/ Mobile\//.test(a)&&a.match(/iPad|iPod|iPhone/)){g.mobile="apple";if((e=a.match(/OS ([^\s]*)/))&&e[1])g.ios=h(e[1].replace("_","."));b="ios";if((e=a.match(/iPad|iPod|iPhone/))&&e[0])g[e[0].toLowerCase()]=g.ios}else if(/ Android/i.test(a)){if(/Mobile/.test(a)&&(b=g.mobile="android"),(e=a.match(/Android ([^\s]*);/))&&
e[1])g.android=h(e[1])}else if(e=a.match(/NokiaN[^\/]*|Android \d\.\d|webOS\/\d\.\d/))g.mobile=e[0].toLowerCase();if((e=a.match(/PhantomJS\/([^\s]*)/))&&e[1])g.phantomjs=h(e[1])}else if((e=a.match(/Presto\/([\d.]*)/))&&e[1]){if(g[d="presto"]=h(e[1]),(e=a.match(/Opera\/([\d.]*)/))&&e[1]){g[c="opera"]=h(e[1]);if((e=a.match(/Opera\/.* Version\/([\d.]*)/))&&e[1])g[c]=h(e[1]);if((e=a.match(/Opera Mini[^;]*/))&&e)g.mobile=e[0].toLowerCase();else if((e=a.match(/Opera Mobi[^;]*/))&&e)g.mobile=e[0]}}else if(r=
j(a))g[c="ie"]=r,k(a,g);else if(e=a.match(/Gecko/)){g[d="gecko"]=0.1;if((e=a.match(/rv:([\d.]*)/))&&e[1])g[d]=h(e[1]),/Mobile|Tablet/.test(a)&&(g.mobile="firefox");if((e=a.match(/Firefox\/([\d.]*)/))&&e[1])g[c="firefox"]=h(e[1])}b||(/windows|win32/i.test(a)?b="windows":/macintosh|mac_powerpc/i.test(a)?b="macintosh":/linux/i.test(a)?b="linux":/rhino/i.test(a)&&(b="rhino"));g.os=b;g.core=g.core||d;g.shell=c;g.ieMode=g.ie&&n.documentMode||g.ie;return g}var g=a.Env.host,n=g.document,g=g.navigator,b=KISSY.UA=
c(g&&g.userAgent||"");if("object"===typeof process){var d,i;if((d=process.versions)&&(i=d.node))b.os=process.platform,b.nodejs=h(i)}b.getDescriptorFromUserAgent=c;d="webkit,trident,gecko,presto,chrome,safari,firefox,ie,opera".split(",");i=n&&n.documentElement;var e="";i&&(a.each(d,function(a){var d=b[a];d&&(e+=" ks-"+a+(parseInt(d)+""),e+=" ks-"+a)}),a.trim(e)&&(i.className=a.trim(i.className+e)))})(KISSY);
(function(a,f){function h(a){if(w[a])return w[a];if(!t||a in t)w[a]={name:a,prefix:""};else{for(var b=a.charAt(0).toUpperCase()+a.slice(1),d,e=c.length;e--;)d=c[e]+b,d in t&&(w[a]={name:d,prefix:c[e]});w[a]=w[a]||{name:a,prefix:!1}}return w[a]}var k=a.Env.host,j=a.UA,c=["","Webkit","Moz","O","ms"],g=k.document||{},n,b,d,i,e,o,l,m=g.documentElement,t,s=!0,p=!1,r="ontouchstart"in g&&!j.phantomjs,q=j.ieMode;if(m&&(m.querySelector&&8!==q&&(p=!0),t=m.style,a.each(c,function(a){var b=a?a+"Transition":"transition",
c=a?a+"Transform":"transform";e===f&&b in t&&(e=a,d=b);o===f&&c in t&&(o=a,i=c)}),s="classList"in m,j=k.navigator||{},n="msPointerEnabled"in j,b="pointerEnabled"in j,i))try{var u=g.createElement("p");m.insertBefore(u,m.firstChild);u.style[i]="translate3d(1px,1px,1px)";var x=k.getComputedStyle(u),E=x.getPropertyValue(i)||x[i];m.removeChild(u);l=E!==f&&0<E.length&&"none"!==E}catch(L){l=!0}var w={};a.Features={isMsPointerSupported:function(){return n},isPointerSupported:function(){return b},isTouchEventSupported:function(){return r},
isTouchGestureSupported:function(){return r||b||n},isDeviceMotionSupported:function(){return!!k.DeviceMotionEvent},isHashChangeSupported:function(){return"onhashchange"in k&&(!q||7<q)},isTransitionSupported:function(){return e!==f},isTransformSupported:function(){return o!==f},isTransform3dSupported:function(){return l},isClassListSupported:function(){return s},isQuerySelectorSupported:function(){return!a.config("dom/selector")&&p},isIELessThan:function(a){return!!(q&&q<a)},getTransitionPrefix:function(){return e},
getTransformPrefix:function(){return o},getTransitionProperty:function(){return d},getTransformProperty:function(){return i},getVendorCssPropPrefix:function(a){return h(a).prefix},getVendorCssPropName:function(a){return h(a).name}}})(KISSY);(function(a){(a.Loader={}).Status={ERROR:-1,INIT:0,LOADING:1,LOADED:2,READY_TO_ATTACH:3,ATTACHING:4,ATTACHED:5}})(KISSY);
(function(a){function f(a){if("string"===typeof a)return h(a);for(var b=[],d=0,c=a.length;d<c;d++)b[d]=h(a[d]);return b}function h(b){"/"===b.charAt(b.length-1)&&(b+="index");a.endsWith(b,".js")&&(b=b.slice(0,-3));return b}function k(b,d){var c=d.indexOf("!");if(-1!==c){var e=d.substring(0,c),d=d.substring(c+1);a.use(e,{sync:!0,success:function(a,c){c.alias&&(d=c.alias(b,d,e))}})}return d}var j=a.Loader,c=a.Path,g=a.Env.host,n=a.startsWith,b=j.Status,d=b.ATTACHED,i=b.READY_TO_ATTACH,e=b.LOADED,o=
b.ATTACHING,l=b.ERROR,m=j.Utils={},t=g.document;a.mix(m,{docHead:function(){return t.getElementsByTagName("head")[0]||t.documentElement},normalDepModuleName:function(a,b){var d=0,e;if(!b)return b;if("string"===typeof b)return n(b,"../")||n(b,"./")?c.resolve(c.dirname(a),b):c.normalize(b);for(e=b.length;d<e;d++)b[d]=m.normalDepModuleName(a,b[d]);return b},createModulesInfo:function(b,d){a.each(d,function(a){m.createModuleInfo(b,a)})},createModuleInfo:function(b,d,c){var d=h(d),e=b.Env.mods,f=e[d];
return f?f:e[d]=f=new j.Module(a.mix({name:d,runtime:b},c))},getModules:function(b,d){var c=[b],e,f,i,g,h=b.Env.mods;a.each(d,function(d){e=h[d];!e||"css"!==e.getType()?(f=m.unalias(b,d),(i=a.reduce(f,function(a,b){g=h[b];return a&&g&&g.status>=o},!0))?c.push(h[f[0]].exports):c.push(null)):c.push(void 0)});return c},attachModsRecursively:function(a,b){var d,c=a.length;for(d=0;d<c;d++)m.attachModRecursively(a[d],b)},checkModsLoadRecursively:function(a,b,d,c,e){var d=d||[],e=e||{},f,i=1,g=a.length,
h=d.length;for(f=0;f<g;f++)i=i&&m.checkModLoadRecursively(a[f],b,d,c,e),d.length=h;return!!i},checkModLoadRecursively:function(a,b,d,c,f){var g,h=b.Env.mods[a];if(a in f)return f[a];if(!h)return f[a]=!1;g=h.status;return g===l?(c.push(h),f[a]=!1):g>=i?f[a]=!0:g!==e?f[a]=!1:m.checkModsLoadRecursively(h.getNormalizedRequires(),b,d,c,f)?(h.status=i,f[a]=!0):f[a]=!1},attachModRecursively:function(a,b){var d=b.Env.mods[a];d.status>=o||(d.status=o,d.cjs||m.attachModsRecursively(d.getNormalizedRequires(),
b),m.attachMod(b,d))},attachMod:function(b,c){var e=c.factory;if("function"===typeof e){var f;c.requires&&c.requires.length&&(f=a.bind(c.require,c));e=e.apply(c,c.cjs?[b,f,c.exports,c]:m.getModules(b,c.getRequiresWithAlias()));void 0!==e&&(c.exports=e)}else c.exports=e;c.status=d},getModNamesAsArray:function(a){"string"===typeof a&&(a=a.replace(/\s+/g,"").split(","));return a},normalizeModNames:function(a,b,d){return m.unalias(a,m.normalizeModNamesWithAlias(a,b,d))},unalias:function(a,b){for(var d=
[].concat(b),c,e,i,g=0,h,j=a.Env.mods;!g;){g=1;for(c=d.length-1;0<=c;c--)if((e=j[d[c]])&&"alias"in e){g=0;i=e.alias;"string"===typeof i&&(i=[i]);for(h=i.length-1;0<=h;h--)i[h]||i.splice(h,1);d.splice.apply(d,[c,1].concat(f(i)))}}return d},normalizeModNamesWithAlias:function(a,b,d){var c=[],e,i;if(b){e=0;for(i=b.length;e<i;e++)b[e]&&c.push(k(a,f(b[e])))}d&&(c=m.normalDepModuleName(d,c));return c},registerModule:function(b,d,c,f){var d=h(d),i=b.Env.mods,g=i[d];g&&void 0!==g.factory||(m.createModuleInfo(b,
d),g=i[d],a.mix(g,{name:d,status:e,factory:c}),a.mix(g,f))},getHash:function(a){var b=5381,d;for(d=a.length;-1<--d;)b=(b<<5)+b+a.charCodeAt(d);return b+""},getRequiresFromFn:function(a){var b=[];a.toString().replace(s,"").replace(p,function(a,d){b.push(d.match(/^\s*["']([^'"\s]+)["']\s*$/)[1])});return b}});var s=/(\/\*([\s\S]*?)\*\/|([^:]|^)\/\/(.*)$)/mg,p=/[^.'"]\s*require\s*\(([^)]+)\)/g})(KISSY);
(function(a){function f(a,d){return d in a?a[d]:a.runtime.Config[d]}function h(b){a.mix(this,b)}function k(b){this.exports={};this.status=j.Status.INIT;this.factory=this.name=void 0;this.cjs=1;a.mix(this,b);this.waitedCallbacks=[]}var j=a.Loader,c=a.Path,g=j.Utils;h.prototype={constructor:h,reset:function(b){a.mix(this,b)},getTag:function(){return f(this,"tag")},getName:function(){return this.name},getBase:function(){return f(this,"base")},getPrefixUriForCombo:function(){var a=this.name;return this.getBase()+
(a&&!this.isIgnorePackageNameInUri()?a+"/":"")},getPackageUri:function(){this.packageUri||(this.packageUri=new a.Uri(this.getPrefixUriForCombo()));return this.packageUri},getBaseUri:function(){return f(this,"baseUri")},isDebug:function(){return f(this,"debug")},isIgnorePackageNameInUri:function(){return f(this,"ignorePackageNameInUri")},getCharset:function(){return f(this,"charset")},isCombine:function(){return f(this,"combine")},getGroup:function(){return f(this,"group")}};j.Package=h;k.prototype=
{kissy:1,constructor:k,use:function(a,d){a=g.getModNamesAsArray(a);return KISSY.use(g.normalDepModuleName(this.name,a),d)},resolve:function(a){return this.getFullPathUri().resolve(a)},resolveByName:function(a){return g.normalDepModuleName(this.name,a)},require:function(b){return a.require(b,this.name)},wait:function(a){this.waitedCallbacks.push(a)},notifyAll:function(){for(var a,d=this.waitedCallbacks.length,c=0;c<d;c++){a=this.waitedCallbacks[c];try{a(this)}catch(e){setTimeout(function(){throw e;
},0)}}this.waitedCallbacks=[]},getType:function(){var a=this.type;a||(this.type=a=".css"===c.extname(this.name).toLowerCase()?"css":"js");return a},getFullPathUri:function(){var b,d,f,e;if(!this.fullPathUri){if(this.fullpath)d=new a.Uri(this.fullpath);else{d=this.getPackage();b=d.getBaseUri();e=this.getPath();if(d.isIgnorePackageNameInUri()&&(f=d.name))e=c.relative(f,e);d=b.resolve(e);if(b=this.getTag())b+="."+this.getType(),d.query.set("t",b)}this.fullPathUri=d}return this.fullPathUri},getFullPath:function(){var a;
this.fullpath||(a=this.getFullPathUri(),this.fullpath=a.toString());return this.fullpath},getPath:function(){var a;if(!(a=this.path)){a=this.name;var d="."+this.getType(),f="-min";a=c.join(c.dirname(a),c.basename(a,d));this.getPackage().isDebug()&&(f="");a=this.path=a+f+d}return a},getName:function(){return this.name},getPackage:function(){var b;if(!(b=this.packageInfo)){var d=this.name;b=this.runtime.config("packages");var d=d+"/",c="",e;for(e in b)a.startsWith(d,e+"/")&&e.length>c.length&&(c=e);
b=this.packageInfo=b[c]||n}return b},getTag:function(){return this.tag||this.getPackage().getTag()},getCharset:function(){return this.charset||this.getPackage().getCharset()},getRequiresWithAlias:function(){var a=this.requiresWithAlias,d=this.requires;if(!d||0===d.length)return d||[];a||(this.requiresWithAlias=a=g.normalizeModNamesWithAlias(this.runtime,d,this.name));return a},getRequiredMods:function(){var b=this.runtime;return a.map(this.getNormalizedRequires(),function(a){return g.createModuleInfo(b,
a)})},getNormalizedRequires:function(){var a,d=this.normalizedRequiresStatus,c=this.status,e=this.requires;if(!e||0===e.length)return e||[];if((a=this.normalizedRequires)&&d===c)return a;this.normalizedRequiresStatus=c;return this.normalizedRequires=g.normalizeModNames(this.runtime,e,this.name)}};j.Module=k;var n=new h({name:"",runtime:a})})(KISSY);
(function(a){function f(a){var d=0;if(j.webkit)a.sheet&&(d=1);else if(a.sheet)try{a.sheet.cssRules&&(d=1)}catch(c){"NS_ERROR_DOM_SECURITY_ERR"===c.name&&(d=1)}return d}function h(){for(var b in n){var d=n[b],c=d.node;f(c,b)&&(d.callback&&d.callback.call(c),delete n[b])}g=a.isEmptyObject(n)?0:setTimeout(h,k)}var k=30,j=a.UA,c=a.Loader.Utils,g=0,n={};c.pollCss=function(a,d){var c;c=n[a.href]={};c.node=a;c.callback=d;g||h()};c.isCssLoaded=f})(KISSY);
(function(a){var f=a.Env.host.document,h=a.Loader.Utils,k=a.Path,j={},c,g=a.UA;a.getScript=function(n,b,d){function i(){var a=p.readyState;if(!a||"loaded"===a||"complete"===a)p.onreadystatechange=p.onload=null,r(0)}var e=b,o=0,l,m,t,s;a.startsWith(k.extname(n).toLowerCase(),".css")&&(o=1);a.isPlainObject(e)&&(b=e.success,l=e.error,m=e.timeout,d=e.charset,t=e.attrs);e=j[n]=j[n]||[];e.push([b,l]);if(1<e.length)return e.node;var p=f.createElement(o?"link":"script");t&&a.each(t,function(a,b){p.setAttribute(b,
a)});d&&(p.charset=d);o?(p.href=n,p.rel="stylesheet"):(p.src=n,p.async=!0);e.node=p;var r=function(b){var d;if(s){s.cancel();s=void 0}a.each(j[n],function(a){(d=a[b])&&d.call(p)});delete j[n]},b="onload"in p,d=a.Config.forceCssPoll||g.webkit&&536>g.webkit;o&&d&&b&&(b=!1);b?(p.onload=i,p.onerror=function(){p.onerror=null;r(1)}):o?h.pollCss(p,function(){r(0)}):p.onreadystatechange=i;m&&(s=a.later(function(){r(1)},1E3*m));c||(c=h.docHead());o?c.appendChild(p):c.insertBefore(p,c.firstChild);return p}})(KISSY);
(function(a,f){function h(b){b=b.replace(/\\/g,"/");"/"!==b.charAt(b.length-1)&&(b+="/");g?b=g.resolve(b):(a.startsWith(b,"file:")||(b="file:"+b),b=new a.Uri(b));return b}var k=a.Loader,j=k.Utils,c=a.Env.host.location,g,n,b=a.Config.fns;if(!a.UA.nodejs&&c&&(n=c.href))g=new a.Uri(n);a.Config.loadModsFn=function(b,c){a.getScript(b.fullpath,c)};b.packages=function(b){var c,e=this.Config,g=e.packages=e.packages||{};return b?(a.each(b,function(b,d){c=b.name||d;var e=h(b.base||b.path);b.name=c;b.base=e.toString();
b.baseUri=e;b.runtime=a;delete b.path;g[c]?g[c].reset(b):g[c]=new k.Package(b)}),f):!1===b?(e.packages={},f):g};b.modules=function(b){var c=this;b&&a.each(b,function(b,d){var f=j.createModuleInfo(c,d,b);f.status===k.Status.INIT&&a.mix(f,b)})};b.base=function(a){var b=this.Config;if(!a)return b.base;a=h(a);b.base=a.toString();b.baseUri=a;return f}})(KISSY);
(function(a,f){function h(b,c,e,i,h){var j=c&&c.length,k=[],l=[];a.each(c,function(c){var q,m={timeout:h,success:function(){l.push(c);q&&s&&(d.registerModule(b,q.name,s.factory,s.config),s=f);--j||e(l,k)},error:function(){k.push(c);--j||e(l,k)},charset:i};c.combine||(q=c.mods[0],"css"===q.getType()?q=f:g&&(p=q.name,a.now(),m.attrs={"data-mod-name":q.name}));a.Config.loadModsFn(c,m)})}function k(b,c){a.mix(this,{runtime:b,waitingModules:c})}function j(a,b){if(!a&&"function"===typeof b&&1<b.length){var c=
d.getRequiresFromFn(b);c.length&&(a=a||{},a.requires=c)}else a&&a.requires&&!a.cjs&&(a.cjs=0);return a}function c(a,b){for(var a=a.split(/\//),b=b.split(/\//),c=Math.min(a.length,b.length),d=0;d<c&&a[d]===b[d];d++);return a.slice(0,d).join("/")+"/"}var g=10>a.UA.ieMode,n=a.Loader,b=n.Status,d=n.Utils,i=d.getHash,e=b.LOADING,o=b.LOADED,l=b.READY_TO_ATTACH,m=b.ERROR,t=a.now();k.groupTag=t;var s,p;k.add=function(b,c,e,i,h){if(3===h&&a.isArray(c))var k=c,c=e,e={requires:k,cjs:1};if("function"===typeof b||
1===h)if(e=c,c=b,e=j(e,c),g){for(var b=a.Env.host.document.getElementsByTagName("script"),l,h=b.length-1;0<=h;h--)if(k=b[h],"interactive"===k.readyState){l=k;break}b=l?l.getAttribute("data-mod-name"):p;d.registerModule(i,b,c,e);p=null}else s={factory:c,config:e};else g?p=null:s=f,e=j(e,c),d.registerModule(i,b,c,e)};a.augment(k,{use:function(b){var c=a.Config.timeout,e=this.runtime,b=a.keys(this.calculate(b));d.createModulesInfo(e,b);b=this.getComboUrls(b);a.each(b.css,function(b){h(e,b,function(b,
c){a.each(b,function(b){a.each(b.mods,function(b){d.registerModule(e,b.name,a.noop);b.notifyAll()})});a.each(c,function(b){a.each(b.mods,function(a){a.status=m;a.notifyAll()})})},b.charset,c)});a.each(b.js,function(b){h(e,b,function(){a.each(b,function(b){a.each(b.mods,function(a){a.factory||(a.status=m);a.notifyAll()})})},b.charset,c)})},calculate:function(a,b,c){var f,g,i,h,j=this.waitingModules,k=this.runtime,c=c||{},b=b||{};for(f=0;f<a.length;f++)g=a[f],b[g]||(b[g]=1,i=d.createModuleInfo(k,g),
h=i.status,h>=l||(h!==o&&!j.contains(g)&&(h!==e&&(i.status=e,c[g]=1),i.wait(function(a){j.remove(a.name);j.notifyAll()}),j.add(g)),this.calculate(i.getNormalizedRequires(),b,c)));return c},getComboMods:function(b,e){for(var f={},g,i=this.runtime,h=0,j=b.length,k,l,m,n,p,o,s,G,I;h<j;++h){k=b[h];k=d.createModuleInfo(i,k);m=k.getType();I=k.getFullPath();l=k.getPackage();s=l.name;p=l.getCharset();n=l.getTag();G=l.getGroup();o=l.getPrefixUriForCombo();g=l.getPackageUri();var z=s;(k.canBeCombined=l.isCombine()&&
a.startsWith(I,o))&&G?(z=G+"_"+p+"_"+t,(l=e[z])?l.isSameOriginAs(g)?l.setPath(c(l.getPath(),g.getPath())):(z=s,e[s]=g):e[z]=g.clone()):e[s]=g;g=f[m]=f[m]||{};(m=g[z])?1===m.tags.length&&m.tags[0]===n||m.tags.push(n):(m=g[z]=[],m.charset=p,m.tags=[n]);m.push(k)}return f},getComboUrls:function(a){var b=this.runtime.Config,c=b.comboPrefix,d=b.comboSep,e=b.comboMaxFileNum,b=b.comboMaxUrlLength,f={},a=this.getComboMods(a,f),g={},h;for(h in a){g[h]={};for(var j in a[h]){var k=[],l=[],m=a[h][j],n=m.tags,
p=(n=1<n.length?i(n.join("")):n[0])?"?t="+encodeURIComponent(n)+"."+h:"",n=p.length,o=f[j].toString(),s=o.length,t=o+c,A=g[h][j]=[],o=t.length;A.charset=m.charset;A.mods=[];for(var J=function(){A.push({combine:1,fullpath:t+k.join(d)+p,mods:l})},C=0;C<m.length;C++){var B=m[C];A.mods.push(B);var D=B.getFullPath();if(B.canBeCombined){if(D=D.slice(s).replace(/\?.*$/,""),k.push(D),l.push(B),k.length>e||o+k.join(d).length+n>b)k.pop(),l.pop(),J(),k=[],l=[],C--}else A.push({combine:0,fullpath:D,mods:[B]})}k.length&&
J()}}return g}});n.ComboLoader=k})(KISSY);
(function(a,f){function h(b){a.mix(this,{fn:b,waitMods:{}})}var k=a.Loader,j=a.Env,c=k.Utils,g=a.setImmediate,n=k.ComboLoader;h.prototype={constructor:h,notifyAll:function(){var b=this.fn;b&&a.isEmptyObject(this.waitMods)&&(this.fn=null,b())},add:function(a){this.waitMods[a]=1},remove:function(a){delete this.waitMods[a]},contains:function(a){return this.waitMods[a]}};k.WaitingModules=h;a.mix(a,{add:function(b,c,f){n.add(b,c,f,a,arguments.length)},use:function(b,d){function i(){++t;var b=[];a.now();
c.checkModsLoadRecursively(e,a,f,b)?(c.attachModsRecursively(e,a),d&&(m?s():g(s))):b.length?k&&(m?k.apply(a,b):g(function(){k.apply(a,b)})):(p.fn=i,j.use(e))}var e,j,k,m,t=0,s,p=new h(i);a.isPlainObject(d)&&(m=d.sync,k=d.error,d=d.success);s=function(){d.apply(a,c.getModules(a,b))};b=c.getModNamesAsArray(b);b=c.normalizeModNamesWithAlias(a,b);e=c.unalias(a,b);j=new n(a,p);m?p.notifyAll():g(function(){p.notifyAll()});return a},require:function(b,d){if(b){var f=c.unalias(a,c.normalizeModNamesWithAlias(a,
[b],d));c.attachModsRecursively(f,a);return c.getModules(a,f)[1]}}});j.mods={}})(KISSY);
(function(a){function f(f){var e=f.src||"";if(!e.match(d))return 0;var f=(f=f.getAttribute("data-config"))?(new Function("return "+f))():{},h=f.comboPrefix||g,k=f.comboSep||n,m,t=e.indexOf(h);-1===t?m=e.replace(b,"$1"):(m=e.substring(0,t),"/"!==m.charAt(m.length-1)&&(m+="/"),h=e.substring(t+h.length).split(k),a.each(h,function(a){if(a.match(d))return m+=a.replace(b,"$1"),!1}));"tag"in f||(h=e.lastIndexOf("?t="),-1!==h&&(e=e.substring(h+1),f.tag=j.getHash(c+e)));f.base=f.base||m;return f}function h(){var a=
k.getElementsByTagName("script"),b,c;for(b=a.length-1;0<=b;b--)if(c=f(a[b]))return c;return null}var k=a.Env.host&&a.Env.host.document,j=a.Loader.Utils,c="20140610151400",g="??",n=",",b=/^(.*)(seed|kissy)(?:-min)?\.js[^/]*/i,d=/(seed|kissy)(?:-min)?\.js/i;a.config({comboPrefix:g,comboSep:n,charset:"utf-8",lang:"zh-cn"});a.UA.nodejs?a.config({charset:"utf-8",base:__dirname.replace(/\\/g,"/").replace(/\/$/,"")+"/"}):k&&k.getElementsByTagName&&a.config(a.mix({comboMaxUrlLength:2E3,comboMaxFileNum:40},h()))})(KISSY);
KISSY.add("i18n",{alias:function(a,f){return f+"/i18n/"+a.Config.lang}});
(function(a,f){function h(){if(!b){c&&!j.nodejs&&t(k,l,h);b=1;for(var e=0;e<d.length;e++)try{d[e](a)}catch(f){setTimeout(function(){throw f;},0)}}}var k=a.Env.host,j=a.UA,c=k.document,g=c&&c.documentElement,n=k.location,b=0,d=[],i=/^#?([\w-]+)$/,e=/\S/,o=!(!c||!c.addEventListener),l="load",m=o?function(a,b,c){a.addEventListener(b,c,!1)}:function(a,b,c){a.attachEvent("on"+b,c)},t=o?function(a,b,c){a.removeEventListener(b,c,!1)}:function(a,b,c){a.detachEvent("on"+b,c)};a.mix(a,{isWindow:function(a){return null!=
a&&a==a.window},parseXML:function(a){if(a.documentElement)return a;var b;try{k.DOMParser?b=(new DOMParser).parseFromString(a,"text/xml"):(b=new ActiveXObject("Microsoft.XMLDOM"),b.async=!1,b.loadXML(a))}catch(c){b=f}!b||!b.documentElement||b.getElementsByTagName("parsererror");return b},globalEval:function(a){a&&e.test(a)&&(k.execScript?k.execScript(a):k.eval.call(k,a))},ready:function(c){if(b)try{c(a)}catch(e){setTimeout(function(){throw e;},0)}else d.push(c);return this},available:function(b,d){var b=
(b+"").match(i)[1],e=1,f=a.later(function(){if(500<++e)f.cancel();else{var a=c.getElementById(b);a&&(d(a),f.cancel())}},40,!0)}});if(n&&-1!==(n.search||"").indexOf("ks-debug"))a.Config.debug=!0;(function(){if(!c||"complete"===c.readyState)h();else if(m(k,l,h),o){var a=function(){t(c,"DOMContentLoaded",a);h()};m(c,"DOMContentLoaded",a)}else{var b=function(){"complete"===c.readyState&&(t(c,"readystatechange",b),h())};m(c,"readystatechange",b);var d,e=g&&g.doScroll;try{d=null===k.frameElement}catch(f){d=
!1}if(e&&d){var i=function(){try{e("left"),h()}catch(a){setTimeout(i,40)}};i()}}})();if(j.ie)try{c.execCommand("BackgroundImageCache",!1,!0)}catch(s){}})(KISSY,void 0);(function(a){a.config({modules:{core:{alias:"dom,event,io,anim,base,node,json,ua,cookie".split(",")},ajax:{alias:"io"},"rich-base":{alias:"base"}}});if("undefined"!==typeof location){var f=a.startsWith(location.href,"https")?"https://s.tbcdn.cn/s/kissy/":"http://a.tbcdn.cn/s/kissy/";a.config({packages:{gallery:{base:f},mobile:{base:f}}})}})(KISSY);
(function(a,f,h){a({"anim/transition?":{alias:KISSY.Features.isTransitionSupported()?"anim/transition":""}});a({anim:{requires:["anim/base","anim/timer","anim/transition?"]}});a({"anim/base":{requires:["dom","promise"]}});a({"anim/timer":{requires:["dom","anim/base"]}});a({"anim/transition":{requires:["dom","event/dom","anim/base"]}});a({attribute:{requires:["event/custom"]}});a({base:{requires:["attribute"]}});a({button:{requires:["node","component/control"]}});a({color:{requires:["attribute"]}});
a({combobox:{requires:["node","component/control","menu","attribute","io"]}});a({"component/container":{requires:["component/control","component/manager"]}});a({"component/control":{requires:["node","base","promise","component/manager","xtemplates/runtime"]}});a({"component/extension/align":{requires:["node"]}});a({"component/extension/content-render":{requires:["component/extension/content-xtpl"]}});a({"component/extension/delegate-children":{requires:["node","component/manager"]}});a({"component/plugin/drag":{requires:["dd"]}});
a({"component/plugin/resize":{requires:["resizable"]}});a({"date/format":{requires:["date/gregorian","i18n!date"]}});a({"date/gregorian":{requires:["i18n!date"]}});a({"date/picker":{requires:"node,date/gregorian,i18n!date/picker,component/control,date/format,date/picker-xtpl".split(",")}});a({"date/popup-picker":{requires:["date/picker-xtpl","date/picker","component/extension/shim","component/extension/align"]}});a({dd:{requires:["node","base"]}});a({"dd/plugin/constrain":{requires:["node","base"]}});
a({"dd/plugin/proxy":{requires:["node","dd","base"]}});a({"dd/plugin/scroll":{requires:["node","dd","base"]}});a({"dom/basic":{alias:["dom/base",f.isIELessThan(9)?"dom/ie":"",f.isClassListSupported()?"":"dom/class-list"]},dom:{alias:["dom/basic",!f.isQuerySelectorSupported()?"dom/selector":""]}});a({"dom/base":{requires:["ua"]}});a({"dom/class-list":{requires:["dom/base"]}});a({"dom/ie":{requires:["dom/base"]}});a({"dom/selector":{requires:["dom/basic"]}});a({editor:{requires:["node","html-parser",
"component/control","ua"]}});a({event:{requires:["event/dom","event/custom"]}});a({"event/custom":{requires:["event/base"]}});a({"event/dom":{alias:["event/dom/base",f.isTouchGestureSupported()?"event/dom/touch":"",f.isDeviceMotionSupported()?"event/dom/shake":"",f.isHashChangeSupported()?"":"event/dom/hashchange",f.isIELessThan(9)?"event/dom/ie":"",h.ie?"":"event/dom/focusin"]}});a({"event/dom/base":{requires:["event/base","dom"]}});a({"event/dom/focusin":{requires:["event/dom/base"]}});a({"event/dom/hashchange":{requires:["event/dom/base",
"dom"]}});a({"event/dom/ie":{requires:["event/dom/base","dom"]}});a({"event/dom/shake":{requires:["event/dom/base"]}});a({"event/dom/touch":{requires:["event/dom/base","dom"]}});a({"filter-menu":{requires:["menu","component/extension/content-xtpl","component/extension/content-render"]}});a({io:{requires:["dom","event/custom","promise","event/dom"]}});a({kison:{requires:["base"]}});a({menu:{requires:"node,component/container,component/extension/delegate-children,component/control,component/extension/content-render,component/extension/content-xtpl,component/extension/align,component/extension/shim".split(",")}});
a({menubutton:{requires:["node","button","component/extension/content-xtpl","component/extension/content-render","menu"]}});a({mvc:{requires:["io","json","attribute","node"]}});a({node:{requires:["dom","event/dom","anim"]}});a({overlay:{requires:"component/container,component/extension/shim,component/extension/align,node,component/extension/content-xtpl,component/extension/content-render".split(",")}});a({resizable:{requires:["node","base","dd"]}});a({"resizable/plugin/proxy":{requires:["node","base"]}});
a({"scroll-view":{alias:f.isTouchGestureSupported()?"scroll-view/drag":"scroll-view/base"}});a({"scroll-view/base":{requires:["node","anim","component/container","component/extension/content-render"]}});a({"scroll-view/drag":{requires:["scroll-view/base","node","anim"]}});a({"scroll-view/plugin/pull-to-refresh":{requires:["base"]}});a({"scroll-view/plugin/scrollbar":{requires:["base","node","component/control"]}});a({separator:{requires:["component/control"]}});a({"split-button":{requires:["component/container",
"button","menubutton"]}});a({stylesheet:{requires:["dom"]}});a({swf:{requires:["dom","json","attribute"]}});a({tabs:{requires:["component/container","toolbar","button"]}});a({toolbar:{requires:["component/container","component/extension/delegate-children","node"]}});a({tree:{requires:["node","component/container","component/extension/content-xtpl","component/extension/content-render","component/extension/delegate-children"]}});a({xtemplate:{requires:["xtemplates/runtime","xtemplates/compiler"]}});a({"xtemplates/compiler":{requires:["xtemplates/runtime"]}});
a({"xtemplates/runtime":{requires:["path"]}})})(function(a){KISSY.config("modules",a)},KISSY.Features,KISSY.UA);
(function(a){a.add("ua",function(){return a.UA});a.add("uri",function(){return a.Uri});a.add("path",function(){return a.Path});var f=a.UA,h=a.Env.host,k=(f.nodejs&&"object"===typeof global?global:h).JSON;9>f.ieMode&&(k=null);if(k)a.add("json",function(){return a.JSON=k}),a.parseJson=function(a){return k.parse(a)};else{var j=/^[\],:{}\s]*$/,c=/(?:^|:|,)(?:\s*\[)+/g,g=/\\(?:["\\\/bfnrt]|u[\da-fA-F] {
4
})/g,n=/"[^"\\\r\n]*"|true|false|null|-?(?:\d+\.|)\d+(?:[eE][+-]?\d+|)/g;a.parseJson=function(b){return null===
b?b:"string"===typeof b&&(b=a.trim(b))&&j.test(b.replace(g,"@").replace(n,"]").replace(c,""))?(new Function("return "+b))():a.error("Invalid Json: "+b)}}a.UA.nodejs&&(a.KISSY=a,module.exports=a)})(KISSY);