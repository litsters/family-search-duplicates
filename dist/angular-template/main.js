(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error('Cannot find module "' + req + '".');
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _help_help_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./help/help.component */ "./src/app/help/help.component.ts");
/* harmony import */ var _start_start_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./start/start.component */ "./src/app/start/start.component.ts");
/* harmony import */ var _auth_guard_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./auth-guard.service */ "./src/app/auth-guard.service.ts");
/* harmony import */ var _session_expired_session_expired_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./session-expired/session-expired.component */ "./src/app/session-expired/session-expired.component.ts");
/* harmony import */ var _home_home_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./home/home.component */ "./src/app/home/home.component.ts");
/* harmony import */ var _logout_logout_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./logout/logout.component */ "./src/app/logout/logout.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};








var routes = [
    { path: '', redirectTo: '/start', pathMatch: 'full' },
    { path: 'start', component: _start_start_component__WEBPACK_IMPORTED_MODULE_3__["StartComponent"] },
    { path: 'help', component: _help_help_component__WEBPACK_IMPORTED_MODULE_2__["HelpComponent"] },
    { path: 'logout', component: _logout_logout_component__WEBPACK_IMPORTED_MODULE_7__["LogoutComponent"] },
    { path: 'home', component: _home_home_component__WEBPACK_IMPORTED_MODULE_6__["HomeComponent"], canActivate: [_auth_guard_service__WEBPACK_IMPORTED_MODULE_4__["AuthGuardService"]] },
    { path: 'expired', component: _session_expired_session_expired_component__WEBPACK_IMPORTED_MODULE_5__["SessionExpiredComponent"], canActivate: [_auth_guard_service__WEBPACK_IMPORTED_MODULE_4__["AuthGuardService"]] }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".header-icon {\n  vertical-align: text-bottom !important;\n}\n\n.home-button {\n    font-size: 20px;\n}\n\n.header-spacer {\n  flex: 1 1 auto;\n}\n\n.menu-compact {\n    display: none;\n}\n\n.menu-compact-button {\n    display: block;\n    width: 100%;\n}\n\n@media screen and (max-width: 600px) {\n    .menu-standard {\n        display: none;\n    }\n    .menu-compact {\n        display: inline;\n    }\n}"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<!--<div style=\"text-align:center\">\n  <h1>\n    Welcome to {{ title }}!\n  </h1>\n  <img width=\"300\" alt=\"Angular Logo\" src=\"data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNTAgMjUwIj4KICAgIDxwYXRoIGZpbGw9IiNERDAwMzEiIGQ9Ik0xMjUgMzBMMzEuOSA2My4ybDE0LjIgMTIzLjFMMTI1IDIzMGw3OC45LTQzLjcgMTQuMi0xMjMuMXoiIC8+CiAgICA8cGF0aCBmaWxsPSIjQzMwMDJGIiBkPSJNMTI1IDMwdjIyLjItLjFWMjMwbDc4LjktNDMuNyAxNC4yLTEyMy4xTDEyNSAzMHoiIC8+CiAgICA8cGF0aCAgZmlsbD0iI0ZGRkZGRiIgZD0iTTEyNSA1Mi4xTDY2LjggMTgyLjZoMjEuN2wxMS43LTI5LjJoNDkuNGwxMS43IDI5LjJIMTgzTDEyNSA1Mi4xem0xNyA4My4zaC0zNGwxNy00MC45IDE3IDQwLjl6IiAvPgogIDwvc3ZnPg==\">\n</div>\n<h2>Here are some links to help you start: </h2>\n<ul>\n  <li>\n    <h2><a target=\"_blank\" rel=\"noopener\" href=\"https://angular.io/tutorial\">Tour of Heroes</a></h2>\n  </li>\n  <li>\n    <h2><a target=\"_blank\" rel=\"noopener\" href=\"https://github.com/angular/angular-cli/wiki\">CLI Documentation</a></h2>\n  </li>\n  <li>\n    <h2><a target=\"_blank\" rel=\"noopener\" href=\"https://blog.angular.io/\">Angular blog</a></h2>\n  </li>\n</ul>-->\n\n<mat-toolbar color=\"primary\">\n  <mat-toolbar-row>\n    <button mat-button class=\"home-button\" (click)=\"goHome()\"><mat-icon class=\"header-icon\">favorite</mat-icon> {{link.APP_NAME}}</button>\n\n    <span class=\"header-spacer\"></span>\n    \n    <span class=\"menu-standard\">\n\t    <button mat-button (click)=\"goToRoute(option.href)\" *ngFor=\"let option of link.mainMenu\">{{option.name}}</button>\n\t  </span>\n\n\t  <span class=\"menu-compact\">\n      <mat-menu #appMenu=\"matMenu\">\n        <button mat-button routerLink=\"/{{option.href}}\" *ngFor=\"let option of link.mainMenu\" class=\"menu-compact-button\">{{option.name}}</button>\n      </mat-menu>\n      \n      <button mat-icon-button [matMenuTriggerFor]=\"appMenu\">\n        <mat-icon>more_vert</mat-icon>\n      </button>\n\t  </span>\n  </mat-toolbar-row>\n</mat-toolbar>\n\n\n<router-outlet></router-outlet>\n\n<app-footer></app-footer>\n\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _link_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./link.service */ "./src/app/link.service.ts");
/* harmony import */ var _fs_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./fs.service */ "./src/app/fs.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var AppComponent = /** @class */ (function () {
    function AppComponent(fsService, router, link) {
        this.fsService = fsService;
        this.router = router;
        this.link = link;
        this.title = link.APP_NAME; //Set the title for the page
    }
    //Add more routes here as needed for the main menu
    AppComponent.prototype.ngOnInit = function () {
        var loggedIn = this.fsService.checkLoginStatus();
        if (loggedIn) {
            this.goHome();
        }
    };
    AppComponent.prototype.goHome = function () {
        this.router.navigate([this.link.getHome()]);
    };
    AppComponent.prototype.goToRoute = function (link) {
        if (link.includes('http')) {
            window.open(link, '_blank');
        }
        else if (link === 'home') {
            this.goHome();
        }
        else {
            this.router.navigate([link]);
        }
    };
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        }),
        __metadata("design:paramtypes", [_fs_service__WEBPACK_IMPORTED_MODULE_3__["FsService"], _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"], _link_service__WEBPACK_IMPORTED_MODULE_2__["LinkService"]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
/* harmony import */ var _material_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./material.module */ "./src/app/material.module.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _angular_service_worker__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/service-worker */ "./node_modules/@angular/service-worker/fesm5/service-worker.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! .//app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _help_help_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./help/help.component */ "./src/app/help/help.component.ts");
/* harmony import */ var _start_start_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./start/start.component */ "./src/app/start/start.component.ts");
/* harmony import */ var _loader_loader_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./loader/loader.component */ "./src/app/loader/loader.component.ts");
/* harmony import */ var _link_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./link.service */ "./src/app/link.service.ts");
/* harmony import */ var _session_expired_session_expired_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./session-expired/session-expired.component */ "./src/app/session-expired/session-expired.component.ts");
/* harmony import */ var _footer_footer_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./footer/footer.component */ "./src/app/footer/footer.component.ts");
/* harmony import */ var _home_home_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./home/home.component */ "./src/app/home/home.component.ts");
/* harmony import */ var _fs_service__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./fs.service */ "./src/app/fs.service.ts");
/* harmony import */ var _logout_logout_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./logout/logout.component */ "./src/app/logout/logout.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



















var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"],
                _help_help_component__WEBPACK_IMPORTED_MODULE_9__["HelpComponent"],
                _start_start_component__WEBPACK_IMPORTED_MODULE_10__["StartComponent"],
                _loader_loader_component__WEBPACK_IMPORTED_MODULE_11__["LoaderComponent"],
                _session_expired_session_expired_component__WEBPACK_IMPORTED_MODULE_13__["SessionExpiredComponent"],
                _footer_footer_component__WEBPACK_IMPORTED_MODULE_14__["FooterComponent"],
                _home_home_component__WEBPACK_IMPORTED_MODULE_15__["HomeComponent"],
                _logout_logout_component__WEBPACK_IMPORTED_MODULE_17__["LogoutComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_3__["BrowserAnimationsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClientModule"],
                _material_module__WEBPACK_IMPORTED_MODULE_4__["MaterialModule"],
                _angular_service_worker__WEBPACK_IMPORTED_MODULE_6__["ServiceWorkerModule"].register('/ngsw-worker.js', { enabled: _environments_environment__WEBPACK_IMPORTED_MODULE_7__["environment"].production }),
                _app_routing_module__WEBPACK_IMPORTED_MODULE_8__["AppRoutingModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_18__["FormsModule"]
            ],
            entryComponents: [
                _loader_loader_component__WEBPACK_IMPORTED_MODULE_11__["LoaderComponent"]
            ],
            providers: [_link_service__WEBPACK_IMPORTED_MODULE_12__["LinkService"], _fs_service__WEBPACK_IMPORTED_MODULE_16__["FsService"]],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/auth-guard.service.ts":
/*!***************************************!*\
  !*** ./src/app/auth-guard.service.ts ***!
  \***************************************/
/*! exports provided: AuthGuardService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthGuardService", function() { return AuthGuardService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _fs_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./fs.service */ "./src/app/fs.service.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _link_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./link.service */ "./src/app/link.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var AuthGuardService = /** @class */ (function () {
    function AuthGuardService(location, fsService, router, link) {
        this.location = location;
        this.fsService = fsService;
        this.router = router;
        this.link = link;
    }
    AuthGuardService.prototype.canActivate = function (route, state) {
        //console.log(route.queryParamMap);
        if (route.queryParamMap.has('fstoken')) {
            this.fsService.logIn(route.queryParamMap.get('fstoken'));
            this.router.navigate([route.url[0].path]);
            return false;
        }
        else if (this.fsService.isAuthenticated()) {
            return true;
        }
        else {
            this.router.navigate(['expired']);
            return false;
        }
    };
    AuthGuardService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common__WEBPACK_IMPORTED_MODULE_3__["Location"], _fs_service__WEBPACK_IMPORTED_MODULE_2__["FsService"], _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"], _link_service__WEBPACK_IMPORTED_MODULE_4__["LinkService"]])
    ], AuthGuardService);
    return AuthGuardService;
}());



/***/ }),

/***/ "./src/app/familySearchX/FHTLX.ts":
/*!****************************************!*\
  !*** ./src/app/familySearchX/FHTLX.ts ***!
  \****************************************/
/*! exports provided: FHTLX */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FHTLX", function() { return FHTLX; });
/* harmony import */ var _docCookies__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./docCookies */ "./src/app/familySearchX/docCookies.ts");
/* harmony import */ var _FamilySearchX__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./FamilySearchX */ "./src/app/familySearchX/FamilySearchX.ts");
var __extends = (undefined && undefined.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();


var FHTLX = /** @class */ (function (_super) {
    __extends(FHTLX, _super);
    function FHTLX() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.PARENT_DOMAIN = ''; //".fhtl.byu.edu";
        return _this;
    }
    FHTLX.authServiceRedirect = function (redirectUri) {
        _FamilySearchX__WEBPACK_IMPORTED_MODULE_1__["FamilySearchX"].uploadConfig(redirectUri, function (options) {
            var request = new XMLHttpRequest();
            var uri = "https://auth.fhtl.byu.edu/?redirect=" + options.redirectUri;
            request.open("GET", uri);
            request.send();
        }, function (error) {
        });
    };
    FHTLX.finishAuthService = function (configLocation, callback, failureUri) {
        var accessToken = null;
        if (accessToken = localStorage.getItem("fs_access_token")) {
            // accessToken = window.location.href.split("fstoken=")[1];
            // console.log("Access Token:", accessToken);
        }
        _FamilySearchX__WEBPACK_IMPORTED_MODULE_1__["FamilySearchX"].uploadConfig(configLocation, function (initOptions) {
            var fhtlx = new FHTLX(initOptions);
            // If we already have the token, set it in the cookie.
            if (accessToken) {
                fhtlx.setAccessToken(accessToken);
            }
            var verifyToken = function (error, response) {
                if (!!error) {
                    console.error("Could not obtain auth token.");
                }
                else {
                    callback(fhtlx);
                }
            };
            if (fhtlx.getAccessToken()) {
                callback(fhtlx);
            }
            else if (!fhtlx.oauthResponse(verifyToken) && failureUri) {
                window.location = failureUri;
            }
        }, function (error) {
            console.error("err:", error);
            // window.location = 'login';
            if (failureUri) {
                window.location = failureUri;
            }
        });
    };
    FHTLX.prototype.setAccessToken = function (accessToken) {
        this.accessToken = accessToken;
        if (this.saveAccessToken) {
            // Expire in 24 hours because tokens never last longer than that, though
            // they can expire before that after 1 hour of inactivity.
            _docCookies__WEBPACK_IMPORTED_MODULE_0__["docCookies"].setItem(this.tokenCookie, accessToken, 86400, this.tokenCookiePath, this.PARENT_DOMAIN);
        }
        return this;
    };
    FHTLX.prototype.assignAccessToken = function (accessToken) {
        this.accessToken = accessToken;
    };
    FHTLX.prototype.storeSession = function (fsSession) {
        this.setAccessToken(fsSession.fs_access_token);
        _docCookies__WEBPACK_IMPORTED_MODULE_0__["docCookies"].setItem('FS_SESSION', JSON.stringify(fsSession), 86400, this.tokenCookiePath, this.PARENT_DOMAIN);
    };
    FHTLX.prototype.readyAccessToken = function (fsSession) {
        this.accessToken = fsSession.fs_access_token;
        this.userPID = fsSession.fs_user.pid;
    };
    FHTLX.prototype.deleteSession = function () {
        this.deleteAccessToken();
        _docCookies__WEBPACK_IMPORTED_MODULE_0__["docCookies"].removeItem('FS_SESSION', this.tokenCookiePath, this.PARENT_DOMAIN);
    };
    FHTLX.checkAccessToken = function () {
        var sessionStr = _docCookies__WEBPACK_IMPORTED_MODULE_0__["docCookies"].getItem('FS_SESSION');
        if (!!sessionStr) {
            try {
                var fsSession = JSON.parse(sessionStr);
                return fsSession;
            }
            catch (err) {
                return undefined;
            }
        }
        else {
            return undefined;
        }
    };
    return FHTLX;
}(_FamilySearchX__WEBPACK_IMPORTED_MODULE_1__["FamilySearchX"]));



/***/ }),

/***/ "./src/app/familySearchX/FamilySearchX.ts":
/*!************************************************!*\
  !*** ./src/app/familySearchX/FamilySearchX.ts ***!
  \************************************************/
/*! exports provided: FamilySearchX */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FamilySearchX", function() { return FamilySearchX; });
/*======================================================================================================
[][][][]/
[][][][]    Licensure
[][][][]\

Although this SDK does not directly include any code from the "Lite JS SDK for the FamilySearch API"
github project (https://github.com/FamilySearch/fs-js-lite), it is designed to be compatible therewith.
As such, we will post their MIT licensure statement here, noting that the code in this project is
the exclusive property of Brigam Young University, and was developed by student researchers in the
BYU Family History Technology Lab as an extension to the aformentioned project.

Lite JS SDK for the FamilySearch API License:
--------------------------------------------------------------------------------
MIT License

Copyright (c) 2016 York Solutions

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
--------------------------------------------------------------------------------


======================================================================================================*/
var __extends = (undefined && undefined.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var FSLink = /** @class */ (function () {
    function FSLink() {
    }
    return FSLink;
}());
var FSResourceReference = /** @class */ (function () {
    function FSResourceReference() {
    }
    return FSResourceReference;
}());
var FSExtensibleData = /** @class */ (function () {
    function FSExtensibleData() {
    }
    return FSExtensibleData;
}());
var FSHypermediaEnabledData = /** @class */ (function (_super) {
    __extends(FSHypermediaEnabledData, _super);
    function FSHypermediaEnabledData() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.links = {};
        return _this;
    }
    return FSHypermediaEnabledData;
}(FSExtensibleData));
var FSFamilyView = /** @class */ (function (_super) {
    __extends(FSFamilyView, _super);
    function FSFamilyView() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.children = [];
        return _this;
    }
    return FSFamilyView;
}(FSHypermediaEnabledData));
var FSAttribution = /** @class */ (function (_super) {
    __extends(FSAttribution, _super);
    function FSAttribution() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return FSAttribution;
}(FSExtensibleData));
var FSQualifier = /** @class */ (function () {
    function FSQualifier() {
    }
    return FSQualifier;
}());
var FSSourceReference = /** @class */ (function (_super) {
    __extends(FSSourceReference, _super);
    function FSSourceReference() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.qualifiers = [];
        return _this;
    }
    return FSSourceReference;
}(FSHypermediaEnabledData));
var FSNote = /** @class */ (function (_super) {
    __extends(FSNote, _super);
    function FSNote() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return FSNote;
}(FSHypermediaEnabledData));
var FSConclusion = /** @class */ (function (_super) {
    __extends(FSConclusion, _super);
    function FSConclusion() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.notes = [];
        return _this;
    }
    return FSConclusion;
}(FSHypermediaEnabledData));
var FSGender = /** @class */ (function (_super) {
    __extends(FSGender, _super);
    function FSGender() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return FSGender;
}(FSConclusion));
var FSTextValue = /** @class */ (function () {
    function FSTextValue() {
    }
    return FSTextValue;
}());
var FSDate = /** @class */ (function (_super) {
    __extends(FSDate, _super);
    function FSDate() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.normalized = [];
        return _this;
    }
    return FSDate;
}(FSExtensibleData));
var FSNamePart = /** @class */ (function (_super) {
    __extends(FSNamePart, _super);
    function FSNamePart() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.qualifiers = [];
        return _this;
    }
    return FSNamePart;
}(FSExtensibleData));
var FSNameForm = /** @class */ (function (_super) {
    __extends(FSNameForm, _super);
    function FSNameForm() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.parts = [];
        return _this;
    }
    return FSNameForm;
}(FSExtensibleData));
var FSName = /** @class */ (function (_super) {
    __extends(FSName, _super);
    function FSName() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.nameForms = [];
        return _this;
    }
    return FSName;
}(FSConclusion));
var FSPlaceReference = /** @class */ (function (_super) {
    __extends(FSPlaceReference, _super);
    function FSPlaceReference() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.normalized = [];
        return _this;
    }
    return FSPlaceReference;
}(FSExtensibleData));
var FSFact = /** @class */ (function (_super) {
    __extends(FSFact, _super);
    function FSFact() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.qualifiers = [];
        return _this;
    }
    return FSFact;
}(FSConclusion));
var FSDisplayProperties = /** @class */ (function (_super) {
    __extends(FSDisplayProperties, _super);
    function FSDisplayProperties() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.familiesAsParent = [];
        _this.familiesAsChild = [];
        return _this;
    }
    return FSDisplayProperties;
}(FSExtensibleData));
var FSEvidenceReference = /** @class */ (function (_super) {
    __extends(FSEvidenceReference, _super);
    function FSEvidenceReference() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return FSEvidenceReference;
}(FSHypermediaEnabledData));
var FSSubject = /** @class */ (function (_super) {
    __extends(FSSubject, _super);
    function FSSubject() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.evidence = [];
        _this.media = [];
        _this.identifiers = {};
        return _this;
    }
    return FSSubject;
}(FSConclusion));
var FSPerson = /** @class */ (function (_super) {
    __extends(FSPerson, _super);
    function FSPerson() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.names = [];
        _this.facts = [];
        return _this;
    }
    return FSPerson;
}(FSSubject));
var FSRelationship = /** @class */ (function (_super) {
    __extends(FSRelationship, _super);
    function FSRelationship() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.facts = [];
        return _this;
    }
    return FSRelationship;
}(FSSubject));
var FSChildAndParentRelationship = /** @class */ (function (_super) {
    __extends(FSChildAndParentRelationship, _super);
    function FSChildAndParentRelationship() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.fatherFacts = [];
        _this.motherFacts = [];
        return _this;
    }
    return FSChildAndParentRelationship;
}(FSSubject));
var FSUser = /** @class */ (function (_super) {
    __extends(FSUser, _super);
    function FSUser() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.links = {};
        return _this;
    }
    return FSUser;
}(FSExtensibleData));
// #endregion
/*=============================================================================================
[][][][]/
[][][][]    FamilySearchX Definition
[][][][]\
=============================================================================================*/
// #region FSX Definition
var FamilySearchX = /** @class */ (function (_super) {
    __extends(FamilySearchX, _super);
    function FamilySearchX(options) {
        var _this = _super.call(this, options) || this;
        _this.userPID = "";
        return _this;
    }
    /*=============================================================================================
    [][][][]/
    [][][][]    Init & Utils
    [][][][]\
    =============================================================================================*/
    // #region Init and Utils
    /**
     * This method is designed principally as a means of loading up a configuration file.
     * @param uri
     * @param handler
     */
    FamilySearchX.uploadConfig = function (uri, handler, errorHandler) {
        var request = new XMLHttpRequest();
        request.addEventListener("load", function () {
            var data = this.response;
            if (data instanceof String) {
                handler(JSON.parse(data));
            }
            else {
                handler(data);
            }
        });
        request.addEventListener("error", function () {
            errorHandler(this.response);
        });
        request.open("GET", uri);
        request.responseType = "json";
        request.send();
    };
    FamilySearchX.prototype.logout = function (handler) {
        this.post("/platform/logout", {}, function (error, response) {
            console.log("%c User has been logged out", "color: #ffdd00");
            handler && handler(error, response);
        });
    };
    FamilySearchX.prototype.isPID = function (field) {
        return !!(/[a-zA-Z0-9]{4}-[a-zA-Z0-9]{3}/g).exec(field);
    };
    // #endregion
    /*=============================================================================================
    [][][][]/
    [][][][]    User API
    [][][][]\
    =============================================================================================*/
    // #region User API
    /**
     * Gets the current user person
     * @param handler
     */
    FamilySearchX.prototype.getCurrentTreePerson = function (handler) {
        this.get('/platform/tree/current-person', handler);
    };
    /**
     * Gets the information for the current user.
     * @param handler
     */
    FamilySearchX.prototype.getCurrentUser = function (handler) {
        var _this = this;
        this.get('/platform/users/current', function (error, response) {
            try {
                if (!error) {
                    var res = (JSON.parse(response.body));
                    var user = res.users[0];
                    _this.userPID = user.personId;
                    handler(error, user);
                }
            }
            catch (e) {
                handler({ apiError: error, parsingError: e }, null);
            }
        });
    };
    /**
     * Gets a FamilySearch person information for a user.
     * @param user
     * @param handler
     */
    FamilySearchX.prototype.getPersonFromUser = function (user, handler) {
        if (!!user.links && !!user.links.person) {
            this.get(user.links.person.href, handler);
        }
        else {
            this.get("/platform/tree/persons/" + user.personId, handler);
        }
    };
    /**
     * Gets the user's ancestry and returns the RAW results.
     * @param handler
     * @param generations
     * @param spouse
     * @param marriageDetails
     * @param descendants
     * @param personDetails
     */
    FamilySearchX.prototype.getUserWithAncestry = function (handler, generations, spouse, marriageDetails, descendants, personDetails) {
        var _this = this;
        if (generations === void 0) { generations = 8; }
        if (spouse === void 0) { spouse = ""; }
        if (!this.userPID) {
            this.getCurrentUser(function (error, user) {
                _this.getUserWithAncestry(handler, generations, spouse, marriageDetails, descendants, personDetails);
            });
            return;
        }
        else {
            this.getPersonWithAncestry(this.userPID, handler, generations, spouse, marriageDetails, descendants, personDetails);
        }
    };
    /**
     * Gets the user's descendancy and returns the RAW results.
     * @param handler
     * @param generations
     * @param spouse
     * @param marriageDetails
     * @param personDetails
     */
    FamilySearchX.prototype.getUserWithDescendancy = function (handler, generations, spouse, marriageDetails, personDetails) {
        var _this = this;
        if (generations === void 0) { generations = 2; }
        if (spouse === void 0) { spouse = ""; }
        if (!this.userPID) {
            this.getCurrentUser(function (error, user) {
                _this.getUserWithDescendancy(handler, generations, spouse, marriageDetails, personDetails);
            });
            return;
        }
        else {
            this.getPersonWithDescendancy(this.userPID, handler, generations, spouse, marriageDetails, personDetails);
        }
    };
    // #endregion
    /*=============================================================================================
    [][][][]/
    [][][][]    Person API
    [][][][]\
    =============================================================================================*/
    // #region Person API
    /**
     * Get a particular person's data from the family tree
     * @param pid
     * @param handler
     * @param relatives (Optional) boolean whether or not relatives should be included with the results. Defaults to false
     * @param sourceDescriptions (Optional) boolean whether or not sourceDescriptions should be included with the results. Defaults to false
     */
    FamilySearchX.prototype.getPerson = function (pid, handler, relatives, sourceDescriptions) {
        if (relatives === void 0) { relatives = false; }
        if (sourceDescriptions === void 0) { sourceDescriptions = false; }
        var uri = '/platform/tree/persons/' + pid;
        var params = [];
        if (relatives) {
            params.push("relatives=true");
        }
        if (sourceDescriptions) {
            params.push("sourceDescriptions=true");
        }
        if (params.length) {
            uri += "?" + params.join("&");
        }
        this.get(uri, handler);
    };
    /**
     * Get the data for a collection of people.
     * @param pids
     * @param handler
     */
    FamilySearchX.prototype.getPersons = function (pids, handler) {
        var limit = 500;
        // Handle inproperly sized requests.
        if (pids.length > limit) {
            console.error("getPersons() called to FS with", pids.length, "ids. The limit is", limit, ".");
            pids = pids.slice(0, limit);
        }
        var list = pids.reduce(function (curr, pid) {
            return curr += (pid + ",");
        }, "").substr(0, -1);
        // Final API call
        this.get('/platform/tree/persons?pids=' + list, handler);
    };
    /**
     * Gets a person with their ancestry and returns the RAW results.
     * @param pid
     * @param handler
     * @param generations
     * @param spouse
     * @param marriageDetails
     * @param descendants
     * @param personDetails
     */
    FamilySearchX.prototype.getPersonWithAncestry = function (pid, handler, generations, spouse, marriageDetails, descendants, personDetails) {
        if (generations === void 0) { generations = 2; }
        if (spouse === void 0) { spouse = ""; }
        var maxGenerations = 8;
        var baseUri = "/platform/tree/ancestry?person=" + pid;
        var uri = baseUri;
        if (generations > 0) {
            if (generations > maxGenerations) {
                console.error("getPersonWithDescendancy() requested", generations, "generations. The limit is", maxGenerations, ".");
                generations = maxGenerations;
            }
            uri += "&generations=" + generations;
        }
        if (spouse != "") {
            uri += "&spouse=" + spouse;
        }
        if (marriageDetails) {
            uri += "&marriageDetails=true";
        }
        if (personDetails) {
            uri += "&personDetails=true";
        }
        if (descendants) {
            uri += "&descendants=true";
        }
        this.get(uri, handler);
    };
    /**
     * Gets a person with their descendancy and returns the RAW results.
     * @param pid
     * @param handler
     * @param generations
     * @param spouse
     * @param marriageDetails
     * @param personDetails
     */
    FamilySearchX.prototype.getPersonWithDescendancy = function (pid, handler, generations, spouse, marriageDetails, personDetails) {
        if (generations === void 0) { generations = 2; }
        if (spouse === void 0) { spouse = ""; }
        var maxGenerations = 2;
        var baseUri = "/platform/tree/descendancy?person=" + pid;
        var uri = baseUri;
        if (generations > 0) {
            if (generations > maxGenerations) {
                console.error("getPersonWithDescendancy() requested", generations, "generations. The limit is", maxGenerations, ".");
                generations = maxGenerations;
            }
            uri += "&generations=" + generations;
        }
        if (spouse != "") {
            uri += "&spouse=" + spouse;
        }
        if (marriageDetails) {
            uri += "&marriageDetails=true";
        }
        if (personDetails) {
            uri += "&personDetails=true";
        }
        this.get(uri, handler);
    };
    /**
     * Gets a person with their ancestry and returns the processed results.
     * @param pid
     * @param handler
     * @param generations
     * @param spouse
     * @param marriageDetails
     * @param personDetails
     */
    FamilySearchX.prototype.getPersonAncestry = function (pid, handler, generations) {
        var desc = new FSXAncestryBuilder(this, pid, generations);
        // console.log("Running ancestry!");
        desc.run().then(function (res) {
            // console.log("Ancestry Data:", res);
            handler(null, res.people);
        }, function (rej) {
            console.log("Ancestry Failed:", rej);
            handler(rej, []);
        });
    };
    /**
     * Gets a person with their descendancy and returns the processed results.
     * @param pid
     * @param handler
     * @param generations
     * @param spouse
     * @param marriageDetails
     * @param personDetails
     */
    FamilySearchX.prototype.getPersonDescendancy = function (pid, handler, generations) {
        var desc = new FSXDescendancyBuilder(this, pid, generations);
        // console.log("Running descendancy!");
        desc.run().then(function (res) {
            // console.log("Descendancy Data:", res);
            handler(null, res.people);
        }, function (rej) {
            console.log("Descendancy Failed:", rej);
            handler(rej, []);
        });
    };
    /**
     * Gets a person's parents.
     * @param pid
     * @param handler
     */
    FamilySearchX.prototype.getPersonWithParents = function (pid, handler) {
        this.get("/platform/tree/persons/" + pid + "/parents", handler);
    };
    /**
     * Gets a person's spouses.
     * @param pid
     * @param handler
     */
    FamilySearchX.prototype.getPersonWithSpouses = function (pid, handler) {
        this.get("/platform/tree/persons/" + pid + "/spouses", handler);
    };
    /**
     * Gets a person's children.
     * @param pid
     * @param handler
     */
    FamilySearchX.prototype.getPersonWithChildren = function (pid, handler) {
        this.get("/platform/tree/persons/" + pid + "/children", handler);
    };
    /**
     * Gets a person's families.
     * @param pid
     * @param handler
     */
    FamilySearchX.prototype.getPersonWithFamilies = function (pid, handler, sourceDescriptions) {
        var uri = "/platform/tree/persons/" + pid + "/families";
        if (sourceDescriptions) {
            uri += "?sourceDescriptions=true";
        }
        this.get(uri, handler);
    };
    // #endregion
    /*=============================================================================================
    [][][][]/
    [][][][]    Memories and Sources
    [][][][]\
    =============================================================================================*/
    // #region Memories and Sources
    /**
     * Retrieves the description for a portrait picture attached as the primary portrait for an individual.
     * @param pid
     * @param handler
     * @param defaultUri An unencoded URI for a default image if no portrait is found.
     */
    FamilySearchX.prototype.getPersonPortrait = function (pid, handler, defaultUri) {
        var uri = "/platform/tree/persons/" + pid + "/portrait";
        if (defaultUri) {
            uri += "?default=" + encodeURIComponent(defaultUri);
        }
        this.get(uri, handler);
    };
    /**
     * Retrieves descriptions for all of the portrait pictures available for an individual.
     * @param pid
     * @param handler
     */
    FamilySearchX.prototype.getPersonPortraits = function (pid, handler) {
        this.get("/platform/tree/persons/" + pid + "/portraits", handler);
    };
    /**
     * Retrieves descriptions for all of the memories available for an individual.
     * @param pid
     * @param handler
     * @param count <optional> The number of stories to request
     * @param startIndex <optional> The start index for the returned stories
     * @param filter <optional> If there is a particular type of resource desired, a filter may be used. Either "Photo", "Document", or "Story".
     */
    FamilySearchX.prototype.getPersonMemories = function (pid, handler, count, startIndex, filter) {
        var url = "/platform/tree/persons/" + pid + "/memories";
        var params = [];
        if (count > 0) {
            params.push("count=" + count);
        }
        if (startIndex > 0) {
            params.push("start=" + startIndex);
        }
        if (filter && (filter === "Photo" || filter === "Document" || filter === "Story")) {
            params.push("type=" + filter);
        }
        if (params.length) {
            url += "?" + params.join("&");
        }
        this.get("/platform/tree/persons/" + pid + "/memories", handler);
    };
    /**
     * Retrieves descriptions for all of the story memories available for an individual.
     * @param pid
     * @param handler
     * @param count <optional> The number of stories to request. If blank or negative, requests them all.
     * @param startIndex <optional> The start index for the returned stories If blank or negative, defaults to 0.
     */
    FamilySearchX.prototype.getPersonStoryMemories = function (pid, handler, count, startIndex) {
        this.getPersonMemories(pid, handler, count, startIndex, "Story");
    };
    /**
     * Retrieves descriptions for all of the document memories available for an individual.
     * @param pid
     * @param handler
     * @param count <optional> The number of documents to request
     * @param startIndex <optional> The start index for the returned documents
     */
    FamilySearchX.prototype.getPersonDocumentMemories = function (pid, handler, count, startIndex) {
        this.getPersonMemories(pid, handler, count, startIndex, "Document");
    };
    /**
     * Retrieves descriptions for all of the photo memories available for an individual.
     * @param pid
     * @param handler
     * @param count <optional> The number of documents to request
     * @param startIndex <optional> The start index for the returned documents
     */
    FamilySearchX.prototype.getPersonPhotoMemories = function (pid, handler, count, startIndex) {
        this.getPersonMemories(pid, handler, count, startIndex, "Photo");
    };
    /**
     * Retrieves descriptions for all of the memories available for an individual.
     * @param pid
     * @param handler
     * @param count <optional> The number of photos to request
     * @param startIndex <optional> The start index for the returned photos
     */
    FamilySearchX.prototype.getAllPersonMemories = function (pid, handler, count, startIndex) {
        this.getPersonMemories(pid, handler, count, startIndex);
    };
    /**
     * Provides a list of all sources attached to a person.
     * @param pid
     * @param handler
     */
    FamilySearchX.prototype.getPersonSources = function (pid, handler) {
        this.get("/platform/tree/persons/" + pid + "/sources", handler);
    };
    // #endregion
    /*=============================================================================================
    [][][][]/
    [][][][]    Matches & Duplicates
    [][][][]\
    =============================================================================================*/
    // #region Matches
    FamilySearchX.prototype.getPersonDuplicateMatches = function (pid, handler, includeNotAMatchDeclarations) {
        var uri = "/platform/tree/persons/" + pid + "/matches";
        if (includeNotAMatchDeclarations) {
            uri += "?includeNotAMatchDeclarations=true";
        }
        this.get(uri, { headers: { "Accept": "application/x-gedcomx-atom+json" } }, handler);
    };
    FamilySearchX.prototype.getPersonRecordMatches = function (pid, handler, status, count, confidence) {
        if (status === void 0) { status = "pending"; }
        if (count === void 0) { count = 5; }
        if (confidence === void 0) { confidence = -1; }
        var uri = "/platform/tree/persons/" + pid + "/matches";
        var params = [
            "status=" + status,
            "collection=" + encodeURIComponent("records"),
            "count=" + count
        ];
        if (confidence > -1) {
            confidence = Math.min(confidence, 5); // The max cap on this is 5.
            params.push("confidence=" + confidence);
        }
        // Meld all of the query parameters onto the uri
        if (params.length) {
            uri += "?" + params.join("&");
        }
        this.get(uri, { headers: { "Accept": "application/x-gedcomx-atom+json" } }, handler);
    };
    // #endregion
    /*=============================================================================================
    [][][][]/
    [][][][]    Redirect To FamilySearch
    [][][][]\
    =============================================================================================*/
    // #region FamilySearch Redirect
    /**
     * Opens up a new tab to the FamilySearch person page.
     * Differs from viewInFamilySearchTab() in that the API docs say that eventually it might not require the user to reauthenticate.
     * @param pid
     */
    FamilySearchX.prototype.openNewTabFamilySearchPerson = function (pid) {
        window.open("https://api.familysearch.org/redirect?person=" + pid + "&access_token=" + this.getAccessToken());
    };
    /**
     * Opens up a new tab to the FamilySearch person page.
     * Will definitely require the user to log in to FamilySearch again if they haven't already.
     * @param pid
     */
    FamilySearchX.prototype.viewInFamilySearchTab = function (pid) {
        window.open("https://familysearch.org/tree/#view=ancestor&person=" + pid);
    };
    return FamilySearchX;
}(FamilySearch));

/**
 * FamilySearch currently ships descendancy data with a list of people only connected by a
 * descendancyNumber field in their display properties.
 * The descendancyNumber is currently a d'Aboville number.
 * The FSXdAbovilleParser class provides functionality for converting between the string
 * provided and a parsed data object with easy reference to the d'Aboville numbers for parents and the default spouse.
 */
var FSXdAbovilleParser = /** @class */ (function () {
    function FSXdAbovilleParser() {
    }
    /**
     * Extracts relevant data from a descendancy number
     * @param daboId the d'Aboville identifier for a particular person within a tree.
     */
    FSXdAbovilleParser.getData = function (daboId) {
        var parts = daboId.split(".");
        var out = {
            parentA: "",
            parentB: "",
            spouse: "",
            subject: parts.join("."),
            generation: parts.length - 1
        };
        // Calculate Spouse
        out.spouse = parts.slice(0, -1).join(".") + (parts.length > 1 ? "." : "") + this.toggleSpouse(parts[parts.length - 1]);
        var last = parts[parts.length - 1];
        parts = parts.slice(0, -1);
        if (parts.length && !this.isSpouse(last)) {
            if (this.isSpouse(parts[parts.length - 1])) {
                out.parentA = parts.slice(0, -1).join(".") + (parts.length > 1 ? "." : "") + this.toggleSpouse(parts[parts.length - 1]);
                out.parentB = parts.join(".");
            }
            else {
                out.parentA = parts.join(".");
                out.parentB = parts.slice(0, -1).join(".") + (parts.length > 1 ? "." : "") + this.toggleSpouse(parts[parts.length - 1]);
            }
        }
        return out;
    };
    FSXdAbovilleParser.isSpouse = function (target) {
        return (target.indexOf("-S") !== -1);
    };
    FSXdAbovilleParser.toggleSpouse = function (target) {
        if (!this.isSpouse(target)) {
            return target + "-S";
        }
        else {
            return target.split("-S")[0];
        }
    };
    return FSXdAbovilleParser;
}());
var FSXPedigreeBuilder = /** @class */ (function () {
    function FSXPedigreeBuilder(fsx, pid, generations) {
        this.fsx = fsx;
        this.pid = pid;
        this.generations = generations;
        if (generations > this.getMaxRecommendedGenerations()) {
            console.error("You requested downloading", this.generations, "generations of data. This may take a while.");
        }
        this.cache = {};
    }
    FSXPedigreeBuilder.prototype.run = function () {
        var _this = this;
        var allPeople = [];
        return new Promise(function (resolve, reject) {
            var leavesOutStanding = 0;
            var runStep = function (pid, generationsRemaining) {
                // console.log("Step:", generationsRemaining);
                var nextSet = Math.min(generationsRemaining, _this.getMaxGenerations());
                leavesOutStanding++;
                _this.runGenerations(pid, nextSet).then(function (data) {
                    generationsRemaining -= nextSet;
                    allPeople = allPeople.concat(data.allPeople);
                    if (--leavesOutStanding === 0) {
                        resolve({
                            root: _this.pid,
                            people: allPeople
                        });
                        return;
                    }
                    if (generationsRemaining !== 0 && data.leafIds.length != 0) {
                        data.leafIds.forEach(function (leaf) {
                            runStep(leaf, generationsRemaining);
                        });
                    }
                }, function (rejection) {
                    reject(rejection);
                });
            };
            runStep(_this.pid, _this.generations);
        });
    };
    /**
     * Descendancy data does not ship with relationship references. We're going to add them, so we
     * generate the appropriate arrays in the display properties.
     * @param person
     */
    FSXPedigreeBuilder.prototype.addRelationshipArrays = function (person) {
        if (!person.display.familiesAsParent) {
            person.display.familiesAsParent = [];
        }
        if (!person.display.familiesAsChild) {
            person.display.familiesAsChild = [];
        }
    };
    /**
     * Adds a child for a person under a particular spouse.
     * @param subject The person receiving a child
     * @param spouseId The ID of the other parent of the child
     * @param childId The PID of the child
     */
    FSXPedigreeBuilder.prototype.addChild = function (subject, spouseId, childId) {
        var spouseView;
        var childObject = {
            resource: "FSXChildof-" + subject.id + "," + spouseId + ":" + childId,
            resourceId: childId
        };
        if (!subject.display.familiesAsParent.some(function (view) {
            if (view.parent1.resourceId === subject.id || view.parent2.resourceId === subject.id) {
                spouseView = view;
                if (!view.children.some(function (ref) {
                    return ref.resourceId === childId;
                })) {
                    view.children.push(childObject);
                }
                return true;
            }
            return false;
        })) {
            spouseView = new FSFamilyView();
            spouseView.links = {};
            spouseView.id = "FSXFamilyViewof-" + subject.id + "," + spouseId;
            spouseView.parent1 = {
                resource: "FSXSpouseof-" + subject.id + ":" + spouseId,
                resourceId: subject.id
            };
            spouseView.parent2 = {
                resource: "FSXSpouseof-" + spouseId + ":" + subject.id,
                resourceId: spouseId
            };
            spouseView.children = [
                childObject
            ];
            subject.display.familiesAsParent.push(spouseView);
        }
    };
    /**
     * Adds a spouse to a person, creating a families as parent entry with the designated spouse.
     * @param subject The person receiving a child
     * @param spouseId The ID of the spouse
     */
    FSXPedigreeBuilder.prototype.addSpouse = function (subject, spouseId) {
        var spouseView;
        if (!subject.display.familiesAsParent.some(function (view) {
            return (view.parent1.resourceId === spouseId || view.parent2.resourceId === spouseId);
        })) {
            spouseView = new FSFamilyView();
            spouseView.links = {};
            spouseView.id = "FSXFamilyViewof-" + subject.id + "," + spouseId;
            spouseView.parent1 = {
                resource: "FSXSpouseof-" + subject.id + ":" + spouseId,
                resourceId: subject.id
            };
            spouseView.parent2 = {
                resource: "FSXSpouseof-" + spouseId + ":" + subject.id,
                resourceId: spouseId
            };
            spouseView.children = [];
            subject.display.familiesAsParent.push(spouseView);
        }
        // console.log("Added spouse:", subject.id, spouseId, spouseView);
    };
    /**
     * Adds a spouse to a person, creating a families as parent entry with the designated spouse.
     * @param subject The person receiving a child
     * @param spouseId The ID of the spouse
     */
    FSXPedigreeBuilder.prototype.addParents = function (subject, parentAId, parentBId) {
        var spouseView;
        var childReference = {
            resource: "FSXChildof-" + parentAId + "," + parentBId + ":" + subject.id,
            resourceId: subject.id
        };
        if (!subject.display.familiesAsChild.some(function (view) {
            if ((view.parent1.resourceId == parentAId && view.parent2.resourceId === parentBId) ||
                (view.parent1.resourceId == parentBId && view.parent2.resourceId === parentAId)) {
                if (!view.children.some(function (ref) {
                    return (ref.resourceId === subject.id);
                })) {
                    view.children.push(childReference);
                }
                return true;
            }
            return false;
        })) {
            spouseView = new FSFamilyView();
            spouseView.links = {};
            spouseView.id = "FSXFamilyViewof-" + parentAId + "," + parentBId;
            spouseView.parent1 = {
                resource: "FSXSpouseof-" + parentAId + ":" + parentBId,
                resourceId: parentAId
            };
            spouseView.parent2 = {
                resource: "FSXSpouseof-" + parentBId + ":" + parentAId,
                resourceId: parentBId
            };
            spouseView.children = [childReference];
            subject.display.familiesAsChild.push(spouseView);
        }
        // console.log("Added parents:", subject.id, parentAId, parentBId);
    };
    return FSXPedigreeBuilder;
}());
var FSXDescendancyBuilder = /** @class */ (function (_super) {
    __extends(FSXDescendancyBuilder, _super);
    function FSXDescendancyBuilder() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    FSXDescendancyBuilder.prototype.getMaxGenerations = function () {
        return FSXDescendancyBuilder.MAX_GENERATIONS_PER_CALL;
    };
    FSXDescendancyBuilder.prototype.getMaxRecommendedGenerations = function () {
        return FSXDescendancyBuilder.MAX_GENERATIONS_RECOMMENDED;
    };
    FSXDescendancyBuilder.prototype.runGenerations = function (pid, generations) {
        var _this = this;
        return new Promise(function (resolve, reject) {
            _this.fsx.getPersonWithDescendancy(_this.pid, function (error, response) {
                if (error) {
                    reject(error);
                    return;
                }
                if (!!response.data) {
                    resolve(_this.connectDescendancyData(response.data.persons, generations));
                    return;
                }
                resolve();
            }, generations, "", true, true);
        });
    };
    /**
     * Given a group of people, it will attach the PID's of linked family members to the people,
     * creating a tree that is more intuitive than using the d'Aboville numbers.
     * @param people
     */
    FSXDescendancyBuilder.prototype.connectDescendancyData = function (people, generations) {
        var _this = this;
        var leaves = [];
        var descMap = {};
        // Cache, fill out the relationship areas, and store the descendancyNumber;
        people.forEach(function (subject) {
            if (!_this.cache[subject.id]) {
                _this.cache[subject.id] = subject;
            }
            _this.addRelationshipArrays(subject);
            descMap[subject.display.descendancyNumber] = subject.id;
        });
        var data, parentAId, parentBId, spouseId, parentA, parentB, spouse;
        var i = 0;
        people.forEach(function (subject) {
            data = FSXdAbovilleParser.getData(subject.display.descendancyNumber); // Get the d'Aboville parsing
            if (data.generation === generations) {
                leaves.push(subject.id);
            }
            parentAId = descMap[data.parentA];
            parentBId = descMap[data.parentB];
            spouseId = descMap[data.spouse];
            if (!!parentAId) {
                parentA = _this.cache[parentAId];
                _this.addChild(parentA, parentBId, subject.id);
            }
            if (!!parentBId) {
                parentB = _this.cache[parentBId];
                _this.addChild(parentB, parentAId, subject.id);
            }
            if (!!parentAId || !!parentBId) {
                _this.addParents(subject, parentAId, parentBId);
            }
            if (!!spouseId) {
                spouse = _this.cache[spouseId];
                _this.addSpouse(subject, spouseId);
            }
        });
        return {
            allPeople: people,
            leafIds: leaves
        };
    };
    FSXDescendancyBuilder.MAX_GENERATIONS_PER_CALL = 2;
    FSXDescendancyBuilder.MAX_GENERATIONS_RECOMMENDED = 5;
    return FSXDescendancyBuilder;
}(FSXPedigreeBuilder));
var FSXAncestryBuilder = /** @class */ (function (_super) {
    __extends(FSXAncestryBuilder, _super);
    function FSXAncestryBuilder() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    FSXAncestryBuilder.prototype.getMaxGenerations = function () {
        return FSXAncestryBuilder.MAX_GENERATIONS_PER_CALL;
    };
    FSXAncestryBuilder.prototype.getMaxRecommendedGenerations = function () {
        return FSXAncestryBuilder.MAX_GENERATIONS_RECOMMENDED;
    };
    FSXAncestryBuilder.prototype.runGenerations = function (pid, generations) {
        var _this = this;
        return new Promise(function (resolve, reject) {
            _this.fsx.getPersonWithAncestry(_this.pid, function (error, response) {
                if (error) {
                    reject(error);
                    return;
                }
                if (!!response.data) {
                    resolve(_this.connectAncestryData(response.data.persons, generations));
                    return;
                }
                resolve();
            }, generations, "", true, false, true);
        });
    };
    FSXAncestryBuilder.prototype.connectAncestryData = function (people, generations) {
        var _this = this;
        var leaves = [];
        var ahnenMap = {};
        // Cache, fill out the relationship areas, and store the descendancyNumber;
        people.forEach(function (subject) {
            if (!_this.cache[subject.id]) {
                _this.cache[subject.id] = subject;
            }
            _this.addRelationshipArrays(subject);
            ahnenMap[subject.display.ascendancyNumber] = subject.id;
        });
        var ahnen, ahnenNumber, parentAAhnen, parentBAhnen, spouseAhnen, parentAId, parentBId, spouseId, parentA, parentB, spouse;
        var i = 0;
        people.forEach(function (subject) {
            ahnen = subject.display.ascendancyNumber;
            if (FSXdAbovilleParser.isSpouse(ahnen)) {
                var spouseAhnen_1 = FSXdAbovilleParser.toggleSpouse(ahnen);
                _this.addSpouse(subject, spouseAhnen_1);
                _this.addSpouse(_this.cache[ahnenMap[spouseAhnen_1]], ahnen);
                return;
            }
            ahnenNumber = parseInt(ahnen);
            parentAId = ahnenMap[ahnenNumber * 2];
            parentBId = ahnenMap[ahnenNumber * 2 + 1];
            spouseId = ahnenMap[FSXdAbovilleParser.toggleSpouse(ahnen)];
            if (!!parentAId) {
                parentA = _this.cache[parentAId];
                _this.addChild(parentA, parentBId, subject.id);
            }
            if (!!parentBId) {
                parentB = _this.cache[parentBId];
                _this.addChild(parentB, parentAId, subject.id);
            }
            if (!!parentAId || !!parentBId) {
                _this.addParents(subject, parentAId, parentBId);
            }
            else if (ahnenNumber >= (i = Math.pow(2, generations)) && ahnenNumber < 2 * i) {
                leaves.push(subject.id);
            }
            if (!!spouseId) {
                spouse = _this.cache[spouseId];
                _this.addSpouse(subject, spouseId);
            }
        });
        return {
            allPeople: people,
            leafIds: leaves
        };
    };
    FSXAncestryBuilder.MAX_GENERATIONS_PER_CALL = 8;
    FSXAncestryBuilder.MAX_GENERATIONS_RECOMMENDED = 16;
    return FSXAncestryBuilder;
}(FSXPedigreeBuilder));
// #endregion


/***/ }),

/***/ "./src/app/familySearchX/docCookies.ts":
/*!*********************************************!*\
  !*** ./src/app/familySearchX/docCookies.ts ***!
  \*********************************************/
/*! exports provided: docCookies */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "docCookies", function() { return docCookies; });
/*\
|*|
|*|  :: cookies.js ::
|*|
|*|  A complete cookies reader/writer framework with full unicode support.
|*|
|*|  Revision #3 - July 13th, 2017
|*|
|*|  https://developer.mozilla.org/en-US/docs/Web/API/document.cookie
|*|  https://developer.mozilla.org/User:fusionchess
|*|  https://github.com/madmurphy/cookies.js
|*|
|*|  This framework is released under the GNU Public License, version 3 or later.
|*|  http://www.gnu.org/licenses/gpl-3.0-standalone.html
|*|
|*|  Syntaxes:
|*|
|*|  * docCookies.setItem(name, value[, end[, path[, domain[, secure]]]])
|*|  * docCookies.getItem(name)
|*|  * docCookies.removeItem(name[, path[, domain]])
|*|  * docCookies.hasItem(name)
|*|  * docCookies.keys()
|*|
\*/
var docCookies = {
    getItem: function (sKey) {
        if (!sKey) {
            return null;
        }
        return decodeURIComponent(document.cookie.replace(new RegExp("(?:(?:^|.*;)\\s*" + encodeURIComponent(sKey).replace(/[\-\.\+\*]/g, "\\$&") + "\\s*\\=\\s*([^;]*).*$)|^.*$"), "$1")) || null;
    },
    setItem: function (sKey, sValue, vEnd, sPath, sDomain, bSecure) {
        if (!sKey || /^(?:expires|max\-age|path|domain|secure)$/i.test(sKey)) {
            return false;
        }
        var sExpires = "";
        if (vEnd) {
            switch (vEnd.constructor) {
                case Number:
                    sExpires = vEnd === Infinity ? "; expires=Fri, 31 Dec 9999 23:59:59 GMT" : "; max-age=" + vEnd;
                    /*
                    Note: Despite officially defined in RFC 6265, the use of `max-age` is not compatible with any
                    version of Internet Explorer, Edge and some mobile browsers. Therefore passing a number to
                    the end parameter might not work as expected. A possible solution might be to convert the the
                    relative time to an absolute time. For instance, replacing the previous line with:
                    */
                    /*
                    sExpires = vEnd === Infinity ? "; expires=Fri, 31 Dec 9999 23:59:59 GMT" : "; expires=" + (new Date(vEnd * 1e3 + Date.now())).toUTCString();
                    */
                    break;
                case String:
                    sExpires = "; expires=" + vEnd;
                    break;
                case Date:
                    sExpires = "; expires=" + vEnd.toUTCString();
                    break;
            }
        }
        var cookie = encodeURIComponent(sKey) + "=" + encodeURIComponent(sValue) + sExpires + (sDomain ? "; domain=" + sDomain : "") + (sPath ? "; path=" + sPath : "") + (bSecure ? "; secure" : "");
        document.cookie = cookie;
        return true;
    },
    removeItem: function (sKey, sPath, sDomain) {
        if (!this.hasItem(sKey)) {
            return false;
        }
        document.cookie = encodeURIComponent(sKey) + "=; expires=Thu, 01 Jan 1970 00:00:00 GMT" + (sDomain ? "; domain=" + sDomain : "") + (sPath ? "; path=" + sPath : "");
        return true;
    },
    hasItem: function (sKey) {
        if (!sKey || /^(?:expires|max\-age|path|domain|secure)$/i.test(sKey)) {
            return false;
        }
        return (new RegExp("(?:^|;\\s*)" + encodeURIComponent(sKey).replace(/[\-\.\+\*]/g, "\\$&") + "\\s*\\=")).test(document.cookie);
    },
    keys: function () {
        var aKeys = document.cookie.replace(/((?:^|\s*;)[^\=]+)(?=;|$)|^\s*|\s*(?:\=[^;]*)?(?:\1|$)/g, "").split(/\s*(?:\=[^;]*)?;\s*/);
        for (var nLen = aKeys.length, nIdx = 0; nIdx < nLen; nIdx++) {
            aKeys[nIdx] = decodeURIComponent(aKeys[nIdx]);
        }
        return aKeys;
    }
};


/***/ }),

/***/ "./src/app/footer/footer.component.css":
/*!*********************************************!*\
  !*** ./src/app/footer/footer.component.css ***!
  \*********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".section-title {\n    padding-left: 14px;\n    font-family: Arial, Helvetica, sans-serif;\n    font-weight: lighter;\n    color: white;\n    margin: 0;\n    font-size: 22px;\n}\n\n.fhtl-link {\n    color: white;\n    font-size: 14px;\n    text-decoration: none;\n}\n\n.fhtl-link:hover {\n    text-decoration: underline;\n}\n\n.section-holder {\n    display: flex;\n    justify-content: center;\n    background-color: #3f51b5;\n    padding: 30px;\n    margin-top: calc(100vh);\n}\n\n.column {\n    display: block;\n    padding: 0px 30px;\n}\n\n.link-item {\n    height: 30px !important;\n}\n\n@media screen and (max-width: 800px) {\n    .section-holder {\n        display: block;\n    }\n    .column {\n        padding-bottom: 20px;\n        width: 50%;\n        display: inline-block;\n        box-sizing: border-box;\n    }\n}\n\n@media screen and (max-width: 620px) {\n    .section-holder {\n        display: block;\n    }\n    .column {\n        padding-bottom: 20px;\n        display: block;\n        margin: auto;\n        width: 250px; /*This number is semi-hardcoded, but works*/\n    }\n    .link-item {\n        height: 24px !important;\n    }\n}"

/***/ }),

/***/ "./src/app/footer/footer.component.html":
/*!**********************************************!*\
  !*** ./src/app/footer/footer.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!--<mat-grid-list cols=\"{{footer.length}}\">\n  \n  <mat-grid-tile class=\"links\" *ngFor=\"let section of footer\">\n    \n    <h1>{{section.title}}</h1>\n\n    <mat-list>\n      <mat-list-item *ngFor=\"let link of section.links\">\n        <a href=\"{{link.href}}\" class=\"fhtl-link\">{{link.name}}</a>  \n      </mat-list-item>\n    </mat-list>\n  \n  </mat-grid-tile>\n  \n</mat-grid-list>\n-->\n\n<div class=\"section-holder\">\n\n  <div class=\"column\" *ngFor=\"let section of footer\">\n    <h1 class=\"section-title\">{{section.title}}</h1>\n\n    <mat-list dense>\n      <mat-list-item class=\"link-item\" *ngFor=\"let link of section.links\">\n        <a href=\"{{link.href}}\" target=\"_blank\" class=\"fhtl-link\">{{link.name}}</a>  \n      </mat-list-item>\n    </mat-list>\n  </div>\n\n</div>\n"

/***/ }),

/***/ "./src/app/footer/footer.component.ts":
/*!********************************************!*\
  !*** ./src/app/footer/footer.component.ts ***!
  \********************************************/
/*! exports provided: FooterComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FooterComponent", function() { return FooterComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _link_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../link.service */ "./src/app/link.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var FooterComponent = /** @class */ (function () {
    function FooterComponent(links) {
        this.links = links;
        this.footer = [
            {
                title: 'Support Fhtl',
                links: [
                    {
                        href: links.FHTL.home,
                        name: 'Home'
                    },
                    {
                        href: links.FHTL.contact,
                        name: 'Contact'
                    },
                    {
                        href: links.FHTL.people,
                        name: 'People'
                    },
                    {
                        href: links.FHTL.donate,
                        name: 'Donate'
                    }
                ]
            },
            {
                title: 'Research',
                links: [
                    {
                        href: links.FHTL.relativeFinder,
                        name: 'Relative Finder'
                    },
                    {
                        href: links.FHTL.virtualPedigreee,
                        name: 'Virtual Pedigree'
                    },
                    {
                        href: links.FHTL.descendancyExplorer,
                        name: 'Descendancy Explorer'
                    },
                    {
                        href: links.FHTL.treeSweeper,
                        name: 'Tree Sweeper'
                    } //TODO add brownie in the future
                ]
            },
            {
                title: 'Visualize',
                links: [
                    {
                        href: links.FHTL.pedigreePie,
                        name: 'Pedigree Pie'
                    },
                    {
                        href: links.FHTL.onePageGenealogy,
                        name: 'One Page Genealogy'
                    },
                    {
                        href: links.FHTL.familyCalendar,
                        name: 'Family Calendar'
                    }
                ]
            },
            {
                title: 'Play',
                links: [
                    {
                        href: links.FHTL.geneopardy,
                        name: 'Geneopardy'
                    },
                    {
                        href: links.FHTL.wheelOfFamilyFortune,
                        name: 'Wheel of Family Fortune'
                    },
                    {
                        href: links.FHTL.ancestorGames,
                        name: 'Ancestor Games'
                    },
                    {
                        href: links.FHTL.recordQuest,
                        name: 'Record Quest'
                    }
                ]
            }
        ];
    }
    FooterComponent.prototype.ngOnInit = function () {
    };
    FooterComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-footer',
            template: __webpack_require__(/*! ./footer.component.html */ "./src/app/footer/footer.component.html"),
            styles: [__webpack_require__(/*! ./footer.component.css */ "./src/app/footer/footer.component.css")]
        }),
        __metadata("design:paramtypes", [_link_service__WEBPACK_IMPORTED_MODULE_1__["LinkService"]])
    ], FooterComponent);
    return FooterComponent;
}());



/***/ }),

/***/ "./src/app/fs.service.ts":
/*!*******************************!*\
  !*** ./src/app/fs.service.ts ***!
  \*******************************/
/*! exports provided: FsService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FsService", function() { return FsService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _link_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./link.service */ "./src/app/link.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _utils_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./utils.service */ "./src/app/utils.service.ts");
/* harmony import */ var _familySearchX_FHTLX__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./familySearchX/FHTLX */ "./src/app/familySearchX/FHTLX.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var FsService = /** @class */ (function () {
    function FsService(http, link, router, utils) {
        this.http = http;
        this.link = link;
        this.router = router;
        this.utils = utils;
        this.isLoggedIn = false;
    }
    FsService.prototype.verifyAuthReady = function () {
        return this.http.get(this.link.getAuthRedirect(window.location.origin + "/home"), {
            responseType: 'text',
            observe: 'response'
        });
    };
    FsService.prototype.isAuthenticated = function () {
        return true;
    };
    FsService.prototype.setLoggedIn = function (fsSession) {
        this.FhtlX.readyAccessToken(fsSession);
        this.link.setHomeLoggedIn();
        this.isLoggedIn = true;
    };
    FsService.prototype.logIn = function (fstoken) {
        this.fsSession = this.parseJwt(fstoken);
        this.initFhtlX();
        this.FhtlX.storeSession(this.fsSession);
        this.setLoggedIn(this.fsSession);
    };
    FsService.prototype.initFhtlX = function () {
        var initOptions = {
            environment: 'production',
            appKey: 'app Key :)',
            redirectUri: 'Put your redirect uri here if you want',
            saveAccessToken: true
        };
        this.FhtlX = new _familySearchX_FHTLX__WEBPACK_IMPORTED_MODULE_5__["FHTLX"](initOptions);
    };
    FsService.prototype.checkLoginStatus = function () {
        this.fsSession = _familySearchX_FHTLX__WEBPACK_IMPORTED_MODULE_5__["FHTLX"].checkAccessToken();
        if (!!this.fsSession) {
            this.initFhtlX();
            this.setLoggedIn(this.fsSession);
            return true;
        }
        else {
            return false;
        }
    };
    FsService.prototype.logOut = function () {
        var _this = this;
        var loaderRef = this.utils.displayLoader('Logging out...', false);
        loaderRef.afterClosed().subscribe(function () {
            return _this.router.navigate(['start']);
        });
        if (!this.FhtlX) {
            loaderRef.close();
            //return this.router.navigate(['start']);
        }
        else {
            return this.FhtlX.logout(function () {
                _this.FhtlX.deleteSession();
                _this.isLoggedIn = false;
                _this.link.logOut();
                loaderRef.close();
                //return this.router.navigate(['start']);
            });
        }
    };
    FsService.prototype.parseJwt = function (token) {
        var base64Url = token.split('.')[1];
        var base64 = base64Url.replace('-', '+').replace('_', '/');
        return JSON.parse(window.atob(base64));
    };
    FsService.prototype.getData = function (pid, component) {
        // this.FhtlX.getPersonDuplicateMatches(pid, (error, response) => {
        //   if(error) console.log(error);
        //   else {
        //     console.log(response);
        //     component.setData(response);
        //   }
        // }, true);
        this.FhtlX.getPerson(pid, function (error, response) {
            if (error)
                console.log(error);
            else {
                console.log(response);
                component.setData(response);
            }
        });
        // let url = '/platform/tree/persons/' + pid + '/matches?flag=fsh';
        // // let url = '/tree/person/research-help/' + pid;
        // // let url = '/platform/tree/persons/' + pid ;
        // return this.FhtlX.get(url, (error, response) => {
        //   if(error) console.log(error);
        //   else {
        //     // let json = JSON.stringify(response);
        //     console.log(response);
        //     component.setData(response);
        //   }
        // });
    };
    FsService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"], _link_service__WEBPACK_IMPORTED_MODULE_2__["LinkService"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"], _utils_service__WEBPACK_IMPORTED_MODULE_4__["UtilsService"]])
    ], FsService);
    return FsService;
}());



/***/ }),

/***/ "./src/app/help/help.component.css":
/*!*****************************************!*\
  !*** ./src/app/help/help.component.css ***!
  \*****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/help/help.component.html":
/*!******************************************!*\
  !*** ./src/app/help/help.component.html ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  help works!\n</p>\n"

/***/ }),

/***/ "./src/app/help/help.component.ts":
/*!****************************************!*\
  !*** ./src/app/help/help.component.ts ***!
  \****************************************/
/*! exports provided: HelpComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HelpComponent", function() { return HelpComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var HelpComponent = /** @class */ (function () {
    function HelpComponent() {
    }
    HelpComponent.prototype.ngOnInit = function () {
    };
    HelpComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-help',
            template: __webpack_require__(/*! ./help.component.html */ "./src/app/help/help.component.html"),
            styles: [__webpack_require__(/*! ./help.component.css */ "./src/app/help/help.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], HelpComponent);
    return HelpComponent;
}());



/***/ }),

/***/ "./src/app/home/home.component.css":
/*!*****************************************!*\
  !*** ./src/app/home/home.component.css ***!
  \*****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/home/home.component.html":
/*!******************************************!*\
  !*** ./src/app/home/home.component.html ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-card align=\"center\" class=\"welcome-card\">\n\t\t<div>\n\t\t\t<h2 class=\"welcome-title\">Send Auth to Server</h2>\n\t\t\t<label>Output Filename</label>\n\t\t\t<input type=\"text\" name=\"input_filename\" [(ngModel)]=\"filename\" />\n\t\t\t<button (click)=\"signalServer()\">IT BEGINS</button><br>\n\t\t</div>\n\n    <div>\n      <h2 class=\"welcome-title\">PID Processing</h2>\n\t\t\t<p>Enter a PID to get information about that person.</p>\n\t\t</div>\n\n\t\t<div>\n\t\t\t<input type=\"text\" name=\"input_pid\" [(ngModel)]=\"pid\"/>\n\t\t\t<button (click)=\"processPid()\">Submit</button> <br>\n\t\t\t<pre style=\"text-align: left\">{{data | json}}</pre>\n\t\t</div>\n      \n</mat-card>\n"

/***/ }),

/***/ "./src/app/home/home.component.ts":
/*!****************************************!*\
  !*** ./src/app/home/home.component.ts ***!
  \****************************************/
/*! exports provided: HomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function() { return HomeComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _fs_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../fs.service */ "./src/app/fs.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var HomeComponent = /** @class */ (function () {
    function HomeComponent(fsService, http) {
        this.fsService = fsService;
        this.http = http;
        this.getSampleFsData();
        this.pid = "";
        this.filename = "default";
    }
    HomeComponent.prototype.getSampleFsData = function () {
        var _this = this;
        this.fsService.FhtlX.getPersonAncestry(this.fsService.fsSession.fs_user.pid, function (error, data) {
            console.log("Ancestry:", data);
            _this.sampleData = data;
        }, 4);
    };
    HomeComponent.prototype.processPid = function () {
        console.log("clicked, processing pid " + this.pid);
        this.fsService.getData(this.pid, this);
    };
    HomeComponent.prototype.setData = function (data) {
        this.data = data;
    };
    HomeComponent.prototype.signalServer = function () {
        console.log("what have you done");
        var authtoken = this.fsService.fsSession.fs_access_token;
        console.log("authtoken: [" + authtoken + "]");
        var filename = this.filename.trim();
        filename = filename.concat(".csv");
        console.log("filename: [" + filename + "]");
        var options = {
            headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpHeaders"]({
                "Authorization": authtoken,
                "Output": filename
            })
        };
        var url = "generate";
        var request = this.http.get(url, options);
        request.subscribe(function (data) {
            console.log(data);
        }, function (error) {
            console.log("ERROR: " + JSON.stringify(error, null, 2));
        });
    };
    HomeComponent.prototype.ngOnInit = function () {
    };
    HomeComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-home',
            template: __webpack_require__(/*! ./home.component.html */ "./src/app/home/home.component.html"),
            styles: [__webpack_require__(/*! ./home.component.css */ "./src/app/home/home.component.css")]
        }),
        __metadata("design:paramtypes", [_fs_service__WEBPACK_IMPORTED_MODULE_1__["FsService"], _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]])
    ], HomeComponent);
    return HomeComponent;
}());



/***/ }),

/***/ "./src/app/link.service.ts":
/*!*********************************!*\
  !*** ./src/app/link.service.ts ***!
  \*********************************/
/*! exports provided: LinkService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LinkService", function() { return LinkService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var LinkService = /** @class */ (function () {
    function LinkService() {
        this.FHTL = {
            auth: 'https://auth.fhtl.byu.edu',
            home: 'https://fhtl.byu.edu',
            contact: 'https://fhtl.byu.edu/contact.html',
            donate: 'https://fhtl.byu.edu/donate.html',
            people: 'https://fhtl.byu.edu/people.html',
            relativeFinder: 'https://www.relativefinder.org',
            virtualPedigreee: 'http://virtual-pedigree.fhtl.byu.edu',
            descendancyExplorer: 'http://descend.fhtl.byu.edu',
            treeSweeper: 'https://beta.treesweeper.fhtl.byu.edu',
            brownie: 'https://fhtl.byu.edu/apps/brownie.html',
            pedigreePie: 'http://pedigree-pie.fhtl.byu.edu',
            onePageGenealogy: 'http://opg.fhtl.byu.edu',
            familyCalendar: 'https://calendar.fhtl.byu.edu',
            geneopardy: 'https://geneopardy.fhtl.byu.edu',
            wheelOfFamilyFortune: 'https://wheel.fhtl.byu.edu',
            ancestorGames: 'https://ancestorgames.fhtl.byu.edu',
            recordQuest: 'https://recordquest.fhtl.byu.edu',
        };
        this.FS = 'https://www.familysearch.org/';
        this.APP_NAME = 'Angular Template';
        this.home = 'start';
        this.mainMenu = [
            { name: 'Home', href: 'home', icon: 'home' },
            { name: 'Help', href: 'help', icon: 'help' },
            { name: 'Contact', href: 'https://fhtl.byu.edu/contact.html', icon: 'contact_mail' },
        ];
    }
    LinkService.prototype.getHome = function () {
        return this.home;
    };
    LinkService.prototype.setHomeLoggedIn = function () {
        this.home = 'home';
        this.mainMenu.push({
            name: 'Logout',
            href: 'logout',
            icon: 'supervised_user'
        });
    };
    LinkService.prototype.logOut = function () {
        this.mainMenu.pop();
        this.home = 'start';
    };
    /**
     *
     * @param redirect the url to return to upon signing in. Defaults to the current url
     */
    LinkService.prototype.getAuthRedirect = function (redirect) {
        if (redirect === void 0) { redirect = window.location.href; }
        return this.FHTL.auth + "?redirect=" + redirect;
    };
    LinkService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [])
    ], LinkService);
    return LinkService;
}());



/***/ }),

/***/ "./src/app/loader/loader.component.css":
/*!*********************************************!*\
  !*** ./src/app/loader/loader.component.css ***!
  \*********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".message {\n    font-family: Arial, Helvetica, sans-serif;\n    font-size: 0.9rem;\n    font-weight: bold;\n}"

/***/ }),

/***/ "./src/app/loader/loader.component.html":
/*!**********************************************!*\
  !*** ./src/app/loader/loader.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-dialog-content>\n  <mat-grid-list cols=\"2\">\n    <mat-grid-tile>\n      <mat-spinner [diameter]=\"50\"></mat-spinner>\n    </mat-grid-tile>\n    <mat-grid-tile>\n      <p class=\"message\">{{data.message}}</p>\n    </mat-grid-tile>\n  </mat-grid-list>\n</mat-dialog-content>\n"

/***/ }),

/***/ "./src/app/loader/loader.component.ts":
/*!********************************************!*\
  !*** ./src/app/loader/loader.component.ts ***!
  \********************************************/
/*! exports provided: LoaderComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoaderComponent", function() { return LoaderComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (undefined && undefined.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};


var LoaderComponent = /** @class */ (function () {
    function LoaderComponent(data) {
        this.data = data;
    }
    LoaderComponent.prototype.ngOnInit = function () {
    };
    LoaderComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-loader',
            template: __webpack_require__(/*! ./loader.component.html */ "./src/app/loader/loader.component.html"),
            styles: [__webpack_require__(/*! ./loader.component.css */ "./src/app/loader/loader.component.css")]
        }),
        __param(0, Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"])(_angular_material__WEBPACK_IMPORTED_MODULE_1__["MAT_DIALOG_DATA"])),
        __metadata("design:paramtypes", [Object])
    ], LoaderComponent);
    return LoaderComponent;
}());



/***/ }),

/***/ "./src/app/logout/logout.component.css":
/*!*********************************************!*\
  !*** ./src/app/logout/logout.component.css ***!
  \*********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/logout/logout.component.html":
/*!**********************************************!*\
  !*** ./src/app/logout/logout.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n"

/***/ }),

/***/ "./src/app/logout/logout.component.ts":
/*!********************************************!*\
  !*** ./src/app/logout/logout.component.ts ***!
  \********************************************/
/*! exports provided: LogoutComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LogoutComponent", function() { return LogoutComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _fs_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../fs.service */ "./src/app/fs.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var LogoutComponent = /** @class */ (function () {
    function LogoutComponent(fsService) {
        this.fsService = fsService;
        this.fsService.logOut();
    }
    LogoutComponent.prototype.ngOnInit = function () {
    };
    LogoutComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-logout',
            template: __webpack_require__(/*! ./logout.component.html */ "./src/app/logout/logout.component.html"),
            styles: [__webpack_require__(/*! ./logout.component.css */ "./src/app/logout/logout.component.css")]
        }),
        __metadata("design:paramtypes", [_fs_service__WEBPACK_IMPORTED_MODULE_1__["FsService"]])
    ], LogoutComponent);
    return LogoutComponent;
}());



/***/ }),

/***/ "./src/app/material.module.ts":
/*!************************************!*\
  !*** ./src/app/material.module.ts ***!
  \************************************/
/*! exports provided: MaterialModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MaterialModule", function() { return MaterialModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var MaterialModule = /** @class */ (function () {
    function MaterialModule() {
    }
    MaterialModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatButtonModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatToolbarModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatInputModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatProgressSpinnerModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatCardModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatIconModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSidenavModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatMenuModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatGridListModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatListModule"]],
            exports: [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatButtonModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatToolbarModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatInputModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatProgressSpinnerModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatCardModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatIconModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSidenavModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatMenuModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogModule"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatGridListModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatListModule"]],
        })
    ], MaterialModule);
    return MaterialModule;
}());



/***/ }),

/***/ "./src/app/session-expired/session-expired.component.css":
/*!***************************************************************!*\
  !*** ./src/app/session-expired/session-expired.component.css ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/session-expired/session-expired.component.html":
/*!****************************************************************!*\
  !*** ./src/app/session-expired/session-expired.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  session-expired works!\n</p>\n"

/***/ }),

/***/ "./src/app/session-expired/session-expired.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/session-expired/session-expired.component.ts ***!
  \**************************************************************/
/*! exports provided: SessionExpiredComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SessionExpiredComponent", function() { return SessionExpiredComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var SessionExpiredComponent = /** @class */ (function () {
    function SessionExpiredComponent() {
    }
    SessionExpiredComponent.prototype.ngOnInit = function () {
    };
    SessionExpiredComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-session-expired',
            template: __webpack_require__(/*! ./session-expired.component.html */ "./src/app/session-expired/session-expired.component.html"),
            styles: [__webpack_require__(/*! ./session-expired.component.css */ "./src/app/session-expired/session-expired.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], SessionExpiredComponent);
    return SessionExpiredComponent;
}());



/***/ }),

/***/ "./src/app/start/start.component.css":
/*!*******************************************!*\
  !*** ./src/app/start/start.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".welcome-card {\n    font-family: Arial, Helvetica, sans-serif;\n    font-weight: lighter;\n}\n\n.welcome-title {\n    font-weight: lighter;\n}\n\n.app-description {\n    max-width: 80%;\n    display: block;\n    margin: auto;\n}\n\n.partner-section {\n    display: flex;\n    align-items: center;\n    justify-content: center;\n    margin-top: 30px;\n}\n\n.partner-logo {\n    width: 120px;\n    text-align: center;\n    padding: 0px 20px;\n}\n\n.login-button {\n    width: 250px;\n    max-width: 100%;\n}\n\n.button-border {\n    padding: 30px;\n}\n\n@media screen and (min-width: 1100px) {\n    .welcome-card {\n        max-width: 1000px;\n        margin: 20px auto;\n    }\n}"

/***/ }),

/***/ "./src/app/start/start.component.html":
/*!********************************************!*\
  !*** ./src/app/start/start.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-card align=\"center\" class=\"welcome-card\">\n  <div>\n    <h2 class=\"welcome-title\">Welcome to {{link.APP_NAME}}!</h2>\n    <p class=\"app-description\">{{appDescription}}</p>\n  </div>\n  <div align=\"center\" class=\"button-border\">\n    <button class=\"login-button\" color=\"primary\" mat-raised-button (click)=\"doLogin()\">Login With FamilySearch</button>\n  </div>\n\n  <hr class=\"thin-hr\">\n\n  <div class=\"partner-section\">\n      <img *ngFor=\"let img of partnerLogos\" class=\"partner-logo\" src=\"{{img}}\">    \n  </div>\n</mat-card>\n  "

/***/ }),

/***/ "./src/app/start/start.component.ts":
/*!******************************************!*\
  !*** ./src/app/start/start.component.ts ***!
  \******************************************/
/*! exports provided: StartComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StartComponent", function() { return StartComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _utils_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../utils.service */ "./src/app/utils.service.ts");
/* harmony import */ var _fs_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../fs.service */ "./src/app/fs.service.ts");
/* harmony import */ var _link_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../link.service */ "./src/app/link.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var StartComponent = /** @class */ (function () {
    function StartComponent(utilsService, fsService, link) {
        this.utilsService = utilsService;
        this.fsService = fsService;
        this.link = link;
        this.appDescription = "Lorem ipsum dolor sit amet, mucius dolorem quaerendum vix ut, mei graeco discere definitiones in. Legendos maluisset te qui, id timeam fierent reprehendunt usu. In modus ubique pro, est saepe delectus laboramus an, mei ea tantas consulatu. Id detraxit gloriatur vim.";
        this.partnerLogos = [
            '../../assets/icons/cs-logo.png',
            '../../assets/icons/fhtl.png',
        ];
    }
    StartComponent.prototype.ngOnInit = function () {
    };
    StartComponent.prototype.doLogin = function () {
        var dialogRef = this.utilsService.displayLoader("Please wait...", false);
        this.fsService.verifyAuthReady().subscribe(function (res) {
            dialogRef.close();
            console.debug(res);
            window.location.href = res.url;
        }, function (err) {
            dialogRef.close();
            console.error(err);
        });
    };
    StartComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-start',
            template: __webpack_require__(/*! ./start.component.html */ "./src/app/start/start.component.html"),
            styles: [__webpack_require__(/*! ./start.component.css */ "./src/app/start/start.component.css")]
        }),
        __metadata("design:paramtypes", [_utils_service__WEBPACK_IMPORTED_MODULE_1__["UtilsService"], _fs_service__WEBPACK_IMPORTED_MODULE_2__["FsService"], _link_service__WEBPACK_IMPORTED_MODULE_3__["LinkService"]])
    ], StartComponent);
    return StartComponent;
}());



/***/ }),

/***/ "./src/app/utils.service.ts":
/*!**********************************!*\
  !*** ./src/app/utils.service.ts ***!
  \**********************************/
/*! exports provided: UtilsService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UtilsService", function() { return UtilsService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _loader_loader_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./loader/loader.component */ "./src/app/loader/loader.component.ts");
/* harmony import */ var _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/cdk/overlay */ "./node_modules/@angular/cdk/esm5/overlay.es5.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var UtilsService = /** @class */ (function () {
    function UtilsService(dialog, overlay) {
        this.dialog = dialog;
        this.overlay = overlay;
    }
    UtilsService.prototype.displayLoader = function (message, autoclose, duration) {
        if (autoclose === void 0) { autoclose = true; }
        if (duration === void 0) { duration = 2000; }
        var dialogRef = this.dialog.open(_loader_loader_component__WEBPACK_IMPORTED_MODULE_2__["LoaderComponent"], {
            data: { message: message },
            minHeight: '80px',
            minWidth: '230px',
            scrollStrategy: this.overlay.scrollStrategies.block()
        });
        if (autoclose) {
            setTimeout(function () {
                dialogRef.close();
            }, duration);
        }
        else {
            return dialogRef;
        }
    };
    UtilsService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialog"], _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_3__["Overlay"]])
    ], UtilsService);
    return UtilsService;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * In development mode, to ignore zone related error stack frames such as
 * `zone.run`, `zoneDelegate.invokeTask` for easier debugging, you can
 * import the following file, but please comment it out in production mode
 * because it will have performance impact when throw error
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /home/sam/work/angular-template/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map