/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/
function uriFromPath(e){var n=path.resolve(e).replace(/\\/g,"/");return n.length>0&&"/"!==n.charAt(0)&&(n="/"+n),encodeURI("file://"+n)}function readFile(e){return new Promise(function(n,o){fs.readFile(e,"utf8",function(e,r){e?o(e):n(r)})})}var path=require("path"),fs=require("fs"),loader=require("./vs/loader"),rawNlsConfig=process.env.VSCODE_NLS_CONFIG,nlsConfig=rawNlsConfig?JSON.parse(rawNlsConfig):{availableLanguages:{}};if(nlsConfig._resolvedLanguagePackCoreLocation){let e=Object.create(null);nlsConfig.loadBundle=function(n,o,r){let a=e[n];if(a)return void r(void 0,a);readFile(path.join(nlsConfig._resolvedLanguagePackCoreLocation,n.replace(/\//g,"!")+".nls.json")).then(function(o){let a=JSON.parse(o);e[n]=a,r(void 0,a)}).catch(r)}}loader.config({baseUrl:uriFromPath(__dirname),catchError:!0,nodeRequire:require,nodeMain:__filename,"vs/nls":nlsConfig,nodeCachedDataDir:process.env["VSCODE_NODE_CACHED_DATA_DIR_"+process.pid]}),nlsConfig.pseudo&&loader(["vs/nls"],function(e){
e.setPseudoTranslation(nlsConfig.pseudo)}),exports.bootstrap=function(e,n,o){e&&loader([e],n=n||function(){},o=o||function(e){console.error(e)})};
//# sourceMappingURL=https://ticino.blob.core.windows.net/sourcemaps/d0182c3417d225529c6d5ad24b7572815d0de9ac/core/bootstrap-amd.js.map