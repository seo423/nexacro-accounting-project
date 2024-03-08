(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("employeeform");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("data_for_transaction", this);
            obj._setContents("<ColumnInfo><Column id=\"EMP_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"EMP_NAME\" type=\"STRING\" size=\"256\"/><Column id=\"USER_PW\" type=\"STRING\" size=\"256\"/><Column id=\"WORKPLACE_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"DEPT_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"POSITION_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"SOCIAL_SECURITY_NUMBER\" type=\"STRING\" size=\"256\"/><Column id=\"BIRTH_DATE\" type=\"STRING\" size=\"256\"/><Column id=\"GENDER\" type=\"STRING\" size=\"256\"/><Column id=\"EMAIL\" type=\"STRING\" size=\"256\"/><Column id=\"PHONE_NUMBER\" type=\"STRING\" size=\"256\"/><Column id=\"ZIP_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"BASIC_ADDRESS\" type=\"STRING\" size=\"256\"/><Column id=\"DETAIL_ADDRESS\" type=\"STRING\" size=\"256\"/><Column id=\"LEVEL_OF_EDUCATION\" type=\"STRING\" size=\"256\"/><Column id=\"USER_OR_NOT\" type=\"STRING\" size=\"256\"/><Column id=\"COMPANY_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"DEPT_NAME\" type=\"STRING\" size=\"256\"/><Column id=\"POSITION_NAME\" type=\"STRING\" size=\"256\"/><Column id=\"IMAGE\" type=\"STRING\" size=\"256\"/><Column id=\"WORKPLACE_NAME\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_dept", this);
            obj._setContents("<ColumnInfo><Column id=\"DEPT_NAME\" type=\"STRING\" size=\"256\"/><Column id=\"DEPT_CODE\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"DEPT_NAME\">모든부서</Col></Row><Row><Col id=\"DEPT_NAME\">총무부</Col><Col id=\"DEPT_CODE\">DPT-01</Col></Row><Row><Col id=\"DEPT_NAME\">영업부</Col><Col id=\"DEPT_CODE\">DPT-02</Col></Row><Row><Col id=\"DEPT_NAME\">생산부</Col><Col id=\"DEPT_CODE\">DPT-03</Col></Row><Row><Col id=\"DEPT_NAME\">구매부</Col><Col id=\"DEPT_CODE\">DPT-04</Col></Row><Row><Col id=\"DEPT_NAME\">인사부</Col><Col id=\"DEPT_CODE\">DPT-05</Col></Row><Row><Col id=\"DEPT_NAME\">개발부</Col><Col id=\"DEPT_CODE\">DPT-06</Col></Row><Row><Col id=\"DEPT_NAME\">기술부</Col><Col id=\"DEPT_CODE\">DPT-07</Col></Row><Row><Col id=\"DEPT_NAME\">테스트</Col></Row><Row><Col id=\"DEPT_NAME\">기획부</Col></Row><Row><Col id=\"DEPT_NAME\">홍보부</Col></Row><Row><Col id=\"DEPT_NAME\">회계부</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_img", this);
            obj._setContents("<ColumnInfo><Column id=\"IMAGE\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_empList", this);
            obj._setContents("<ColumnInfo><Column id=\"EMP_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"EMP_NAME\" type=\"STRING\" size=\"256\"/><Column id=\"USER_PW\" type=\"STRING\" size=\"256\"/><Column id=\"POSITION_NAME\" type=\"STRING\" size=\"256\"/><Column id=\"EMAIL\" type=\"STRING\" size=\"256\"/><Column id=\"DEPT_NAME\" type=\"STRING\" size=\"256\"/><Column id=\"SOCIAL_SECURITY_NUMBER\" type=\"STRING\" size=\"256\"/><Column id=\"BASIC_ADDRESS\" type=\"STRING\" size=\"256\"/><Column id=\"USER_OR_NOT\" type=\"STRING\" size=\"256\"/><Column id=\"GENDER\" type=\"STRING\" size=\"256\"/><Column id=\"PHONE_NUMBER\" type=\"STRING\" size=\"256\"/><Column id=\"BIRTH_DATE\" type=\"STRING\" size=\"256\"/><Column id=\"IMAGE\" type=\"STRING\" size=\"256\"/><Column id=\"COMPANY_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"WORKPLACE_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"DEPT_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"POSITION_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"ZIP_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"LEVEL_OF_EDUCATION\" type=\"STRING\" size=\"256\"/><Column id=\"DETAIL_ADDRESS\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new FileDialog("FileDialog", this);
            obj.set_defaultextension("false");
            obj.set_filter("ALL");
            this.addChild(obj.name, obj);


            obj = new VirtualFile("VirtualFile00", this);
            this.addChild(obj.name, obj);


            obj = new FileDialog("empFile", this);
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Div("Div00","1.56%","1.39%","25.78%","97.08%",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("Div00");
            obj.set_background("transparent");
            obj.set_color("transparent");
            this.addChild(obj.name, obj);

            obj = new Combo("deptSerchCombo","36.78%","1.43%","57.45%","4.73%",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("0");
            obj.set_font("normal 12pt/normal \"Arial\"");
            obj.set_color("darkgray");
            obj.set_innerdataset("ds_dept");
            obj.set_codecolumn("DEPT_CODE");
            obj.set_datacolumn("DEPT_NAME");
            obj.set_text("모든부서");
            obj.set_value("");
            obj.set_index("0");
            this.Div00.addChild(obj.name, obj);

            obj = new Grid("emp_information","6.69%","8.31%","89.06%","91.69%",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("1");
            obj.set_autofittype("col");
            obj.set_binddataset("ds_empList");
            obj.set_nodatatext("조회된 사원 정보가 없습니다");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"사원코드\"/><Cell col=\"1\" text=\"사원명\"/><Cell col=\"2\" text=\"부서명\"/><Cell col=\"3\" text=\"직급\"/></Band><Band id=\"body\"><Cell text=\"bind:EMP_CODE\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:EMP_NAME\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:DEPT_NAME\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:POSITION_NAME\" textAlign=\"center\"/></Band></Format></Formats>");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static01","2.13%","1.15%","37.69%","5.59%",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("2");
            obj.set_text("부서별 검색");
            obj.set_textAlign("center");
            obj.set_font("14px/normal \"Gulim\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static00_01_00","31.25%","79.72%","6.02%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("직급");
            obj.set_textAlign("center");
            obj.set_background("#87c4f1");
            obj.set_borderRadius("5px");
            obj.set_color("white");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_02_00","62.50%","51.39%","6.02%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("재직여부");
            obj.set_textAlign("center");
            obj.set_background("#87c4f1");
            obj.set_borderRadius("5px");
            obj.set_color("white");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_00_01_00","62.50%","58.47%","6.02%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("이메일");
            obj.set_textAlign("center");
            obj.set_background("#87c4f1");
            obj.set_borderRadius("5px");
            obj.set_color("white");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_00_00_00_00","62.50%","65.56%","6.02%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("휴대전화");
            obj.set_textAlign("center");
            obj.set_background("#87c4f1");
            obj.set_borderRadius("5px");
            obj.set_color("white");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_01_00_00","62.50%","72.64%","6.02%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("최종학력");
            obj.set_textAlign("center");
            obj.set_background("#87c4f1");
            obj.set_borderRadius("5px");
            obj.set_color("white");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_02_00_00","62.50%","79.72%","6.02%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("기본주소");
            obj.set_textAlign("center");
            obj.set_background("#87c4f1");
            obj.set_borderRadius("5px");
            obj.set_color("white");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_03_00","31.25%","44.31%","6.02%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("사원코드");
            obj.set_textAlign("center");
            obj.set_background("#87c4f1");
            obj.set_borderRadius("5px");
            obj.set_color("white");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_00_02_00","31.25%","51.39%","6.02%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("사원이름");
            obj.set_textAlign("center");
            obj.set_background("#87c4f1");
            obj.set_borderRadius("5px");
            obj.set_color("white");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_00_00_00_01","31.25%","58.47%","6.02%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_text("비밀번호");
            obj.set_textAlign("center");
            obj.set_background("#87c4f1");
            obj.set_borderRadius("5px");
            obj.set_color("white");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_01_00_01","31.25%","65.56%","6.02%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("10");
            obj.set_text("주민번호");
            obj.set_textAlign("center");
            obj.set_background("#87c4f1");
            obj.set_borderRadius("5px");
            obj.set_color("white");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_02_00_01","31.25%","72.64%","6.02%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("11");
            obj.set_text("생년월일");
            obj.set_textAlign("center");
            obj.set_background("#87c4f1");
            obj.set_borderRadius("5px");
            obj.set_color("white");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_00_01_00_01","62.50%","44.31%","6.02%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("12");
            obj.set_text("성별");
            obj.set_textAlign("center");
            obj.set_background("#87c4f1");
            obj.set_borderRadius("5px");
            obj.set_color("white");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_basic_address","71.41%","79.31%","19.61%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("13");
            obj.set_textAlign("center");
            obj.set_readonly("true");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_emp_name","40.08%","51.39%","19.61%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("14");
            obj.set_textAlign("center");
            obj.set_readonly("true");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_emp_code","40.08%","44.31%","19.61%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("15");
            obj.set_textAlign("center");
            obj.set_readonly("true");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_email","71.41%","58.19%","19.61%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("16");
            obj.set_textAlign("center");
            obj.set_readonly("true");
            this.addChild(obj.name, obj);

            obj = new Button("mod_btn","74.45%","88.89%","6.88%","5.56%",null,null,null,null,null,null,this);
            obj.set_taborder("17");
            obj.set_text("수 정");
            this.addChild(obj.name, obj);

            obj = new Button("save_btn","65.31%","88.89%","6.88%","5.56%",null,null,null,null,null,null,this);
            obj.set_taborder("18");
            obj.set_text("등  록");
            this.addChild(obj.name, obj);

            obj = new ImageViewer("emp_img","31.25%","1.39%","18.52%","30.56%",null,null,null,null,null,null,this);
            obj.set_taborder("19");
            obj.set_text("");
            obj.set_stretch("fixaspectratio");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_position_name","40.08%","79.72%","19.61%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("20");
            obj.set_textAlign("center");
            obj.set_readonly("true");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_level_of_education","71.41%","72.64%","19.61%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("21");
            obj.set_textAlign("center");
            obj.set_readonly("true");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_user_or_not","71.41%","51.39%","19.61%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("22");
            obj.set_textAlign("center");
            obj.set_readonly("true");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_gender","71.41%","44.31%","19.61%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("23");
            obj.set_textAlign("center");
            obj.set_readonly("true");
            this.addChild(obj.name, obj);

            obj = new Button("del_btn","83.75%","88.89%","6.88%","5.56%",null,null,null,null,null,null,this);
            obj.set_taborder("24");
            obj.set_text("삭제");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_pw","40.08%","58.47%","19.61%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("25");
            obj.set_textAlign("center");
            obj.set_readonly("true");
            obj.set_password("true");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_social_security_number","40.08%","65.56%","19.61%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("26");
            obj.set_textAlign("center");
            obj.set_readonly("true");
            obj.set_password("true");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_birth_date","40.08%","72.64%","19.61%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("27");
            obj.set_textAlign("center");
            obj.set_readonly("true");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_phone_number","71.41%","65.56%","19.61%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("28");
            obj.set_textAlign("center");
            obj.set_readonly("true");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_dept_name","71.41%","36.81%","19.61%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("29");
            obj.set_textAlign("center");
            obj.set_readonly("true");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_00_01_00_01_00","62.50%","37.22%","6.02%","4.31%",null,null,null,null,null,null,this);
            obj.set_taborder("30");
            obj.set_text("부서명");
            obj.set_textAlign("center");
            obj.set_background("#87c4f1");
            obj.set_borderRadius("5px");
            obj.set_color("white");
            this.addChild(obj.name, obj);

            obj = new Button("img_btn","31.25%","36.11%","6.88%","5.56%",null,null,null,null,null,null,this);
            obj.set_taborder("31");
            obj.set_text("첨 부");
            this.addChild(obj.name, obj);

            obj = new Button("cancel_btn","84.14%","27.78%","6.88%","5.56%",null,null,null,null,null,null,this);
            obj.set_taborder("32");
            obj.set_text("취소");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this.Div00.form
            obj = new Layout("default","",0,0,this.Div00.form,function(p){});
            this.Div00.form.addLayout(obj.name, obj);

            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item5","emp_img","image","ds_img","IMAGE");
            this.addChild(obj.name, obj);
            obj.bind();
            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.addIncludeScript("employeeform.xfdl","scripts::commonOpen.xjs");
        this.registerScript("employeeform.xfdl", function() {
        this.executeIncludeScript("scripts::commonOpen.xjs"); /*include "scripts::commonOpen.xjs"*/
        application = nexacro.getApplication();

        // 온로드로 계속 물통 최신화중
        this.employeeform_onload = function(obj,e)
        {
        	   // obj.parent.parent.Edit_postionCode.set_visible( false );
            // obj.parent.parent.Edit_postionName.set_visible( false );



        	  var id = "findEmployeeList";
              var url = "svcOperate::findEmpList";
              var resData ="";
              var reqData ="ds_empList=gds_emp";
              var args = "";
              var callback = "onload_callbackFunc";

              this.transaction(id, url, resData, reqData, args, callback);


              application.gds_emp.filter('');
              //this.emp_img.set_image(nexacro.getApplication().gds_emp.getColumn(0,'IMAGE'));
              //this.emp_img.set_stretch("fit");
             // trace(this.emp_img.image);
              //this.getDetailCode();



        };

        this.onload_callbackFunc=function(){

          if(this.edit_emp_code.value==undefined){

        	  trace('<<<<<<<<<<<<<<<<<<<<< this is for undefined!!!');
        	  trace('<<<<<<<<<<<<<<<<<<<'+this.edit_emp_code.value+'>>>>>>>>>>>>>>>>>>>>')

        	  this.img_btn.set_visible(false);
        	  this.mod_btn.set_visible(false);
        	  this.del_btn.set_visible(false);
        	  this.cancel_btn.set_visible(false);

        	  }


        trace('<<<<<<< this is callback for onload!!!')
        var cnt = this.ds_empList.getRowCount();
        trace('>>>>>>> emp cnt is : '+cnt)





        }



        // 이거는 뭐하는 로직인지를 모르겠다.
        this.getDetailCode = function(){
              application.gds_detailCode.clear();

              var id = "select";
              var url = "svcBase::codeList";
              var resData ="";
              var reqData ="gds_detailCode=gds_code_detail";
              var args = "";
              var callback = "callback";

              this.transaction(id, url, resData, reqData, args, callback);
        }




        // 부서별 사원조회 - 부서 콤보 바꿀 때
        // 해당 부서에 해당하는 사원만 검색됨
        this.deptSerchCombo = function(obj, e)
        {	trace("e : "+e.posttext);
           var deptName = e.posttext;
           trace(deptName);
           if(deptName == '모든부서'){
              this.ds_empList.filter("");
           }else{
              this.ds_empList.filter("DEPT_NAME=='"+deptName+"'");
           }
        }





        //사원정보보기
        var empCode;

        //ds-empList에 있는 사원정보를 가지고 와서 컴포넌트에 출력

        this.Div00_emp_information_oncellclick = function(obj,e)
        {

        	// 수정모드에서만 활성화되는 버튼들과 컴포넌트들을 비활성화 시킨다.
        	// ---> 수정하다가 다른 사원을 클릭했을때 원래의 상태로 되돌리기 위함

        	// 버튼들의 속성을 변경해주고
        	this.img_btn.set_visible(false);
        	this.cancel_btn.set_visible(false);
        	this.save_btn.set_visible(true);
        	this.mod_btn.set_text('수 정');

        	// edit들을 다시 수정 불가능하게 만든다.
        	this.edit_pw.set_readonly(true);
        	this.edit_email.set_readonly(true);
        	this.edit_phone_number.set_readonly(true);
        	this.edit_basic_address.set_readonly(true);


        					// 아래의 작업은

        	// ds_img에 있는 이전의 사진 정보를 삭제하고
        	trace('<<<<<<< cleared data is : '+this.ds_img.clearData()+' >>>>>>>>');


        	trace('<<<<< image is : '+this.ds_empList.getColumn(e.row,'IMAGE'));
        	//row를 추가하고
        	this.ds_img.addRow();

        	// 선택한 사원의 image 값을 ImageViewer와 바인딩된 데이터셋에 할당
        	this.ds_img.setColumn(0,'IMAGE',this.ds_empList.getColumn(e.row,'IMAGE'));
        	trace('>>>>>>>> ds_img data is : '+this.ds_img.getColumn(0,'IMAGE'));

        	// 각각의 컴포넌트에 값을 할당하고
           this.edit_emp_code.set_value(this.ds_empList.getColumn(e.row,'EMP_CODE'));
           this.edit_emp_name.set_value(this.ds_empList.getColumn(e.row,'EMP_NAME'));
           this.edit_pw.set_value(this.ds_empList.getColumn(e.row,'USER_PW'));
           this.edit_social_security_number.set_value(this.ds_empList.getColumn(e.row,'SOCIAL_SECURITY_NUMBER'));
           this.edit_birth_date.set_value(this.ds_empList.getColumn(e.row,'BIRTH_DATE'));
           this.edit_position_name.set_value(this.ds_empList.getColumn(e.row,'POSITION_NAME'));
           this.edit_dept_name.set_value(this.ds_empList.getColumn(e.row,'DEPT_NAME'));
           this.edit_gender.set_value(this.ds_empList.getColumn(e.row,'GENDER'));
           this.edit_user_or_not.set_value(this.ds_empList.getColumn(e.row,'USER_OR_NOT'));
           this.edit_email.set_value(this.ds_empList.getColumn(e.row,'EMAIL'));
           this.edit_phone_number.set_value(this.ds_empList.getColumn(e.row,'PHONE_NUMBER'))
           this.edit_level_of_education.set_value(this.ds_empList.getColumn(e.row,'LEVEL_OF_EDUCATION'));
           this.edit_basic_address.set_value(this.ds_empList.getColumn(e.row,'BASIC_ADDRESS'));



         //사원정보를 클릭하고 나서는 버튼들을 다시 보이게 한다. ---> edit_emp_code에 값이 있으면은 버튼들이 보이게 한다.
        	 if(this.edit_emp_code.value!=undefined){

        	  trace('<<<<<<<<<<<<<<<<<<<<< this is for not undefined!!!');
        	  trace('<<<<<<<<<<<<<<<<<<<'+this.edit_emp_code.value+'>>>>>>>>>>>>>>>>>>>>')
        	  this.mod_btn.set_visible(true);
        	  this.del_btn.set_visible(true);

        	  }



        };












        //사원 등록 버튼을 누르면 발생하는 이벤트
        this.save_btn_onclick = function(obj,e)
        {
        	var cnt=this.ds_empList.getRowCount();

        	trace('<<<<<<< ds_empList cnt is : '+cnt);



         				//띄울 poppdiv의 정보를 작성하고
         			var sID="employeeaddform";
         			var sURL="popup::employeeaddform.xfdl";
         			var param={}; // 열리는 폼에 파라미터를 넘겨준다.
         			var callbackFunc="employee_add_form_callbackFunc";
         			// 해당 프레임을 생성												 //            --파라미터 순서--
         	var oChildFrame = new ChildFrame(sID,0, 0, 0, 0, null, null, sURL);  // 프레임명, 부모프레임의 왼쪽과의 거리,
         							                                                     // 부모프레임의 상단과의 거리, 해당 프레임의 넓이,
         																				 // 해당 프레임의 높이, 부로 프레임의 오른쪽과의 거리,
         																				 // 부모 프레임과의 하단과의 거리, 참조할 프레임의 주소 ㄴ
         	// 해당 프레임을 화면에 출력												 // 참고 : 해당 프레임의 크기는 변경할수는 없는거 같다.
         		oChildFrame.set_openalign("center middle");
         		oChildFrame.showModal(sID, this.getOwnerFrame(), param, this, callbackFunc);

        };



        //employeeaddform이 닫힐때 넘겨받은 파라미터에 따라  reload여부를 결정
        this.employee_add_form_callbackFunc=function(obj,val){     // obj는 이벤트가 발생한? 객체, val은 이벤트를 발생시킬때 넘겨준 파라미터

        	// close할때 넘겨받은 값을 출력한다.
        	trace('<<< val is : '+val);

        	if(val=='save_btn'){
        		this.reload();
        			trace('----------------------employeeform has been reloaed at employee_add_form_callbackFunc-------------------------------');
        	}else if(val=='esc'){

        		// esc를 눌러서 폼이 종료된거면은 아무런 변경사항도 없으므로
        		// reload하지 않는다.

        	}

        }


        //사진 수정
        this.img_btn_onclick = function(obj,e)
        {
        	this.FileDialog.open("사진첨부", FileDialog.LOAD);
        };





        //사진을  emp_img 에 입력?
        this.FileDialog_onclose = function(obj,e)   //3. 모달꺼지면 실행됨, 아래 Design탭의 Invisible Object에 FileDialog라고 물통있음(사진선택안했으면 e가 null임)
        {
        	trace("모달창닫을때!!!");
        	trace(e.reason);
              vFile = e.virtualfiles[0];    // 사진을 0번째 배열에 넣은 것                      //4. 사진e를 배열에 담고

        	  trace("vFile :"+vFile);

              //var i = vFile.addEventHandler("onsuccess", this.FileList_onsuccess, this);         //5. 사진이 null이 아닐때(성공시) this.FileList_onsuccess메서드 실행
              //var j = vFile.addEventHandler("onerror", this.FileList_onerror, this);            //5. 사진이 null일때(실패시) this.FileList_onerror메서드 실행


        	  // 선택한 파일이 있으면 아래의 코드를 실행
        	  if(vFile!=undefined){
              vFile.open(vFile.fullpath, VirtualFile.openBinary);                           //6. 이줄이있어야 성공시onsuccess메서드, 실패시onerror메서드 호출 가능(둘다헷갈, 안에보면 바이너리라고해서 2진수로 읽어주는애 있음)
              // 선택한 사진을 2진수로 바꿔줌.
        	  vFile.read();                                                      //7. 읽어옴(여기까지가 모달창 꺼질때, 클릭한 사진을 읽어오기까지임)
        		// 2진수로 읽음
        		trace('<<<<<<<<<<<<<< 2진수 : '+vFile.read());

              empFileName = vFile.filename;             // 사진의 이름을 불러온다.
        	  trace(empFileName);
        	  var realPath = system.convertRealPath(vFile.fullpath);                        //9. 실제경로 주고
              this.emp_img.set_image("file://"+realPath);                                 //10 <사진태그>에다가 바탕화면의 사진을 세팅함
              this.emp_img.set_stretch("fit");                                       //11. <사진태그>에 맞게 사진사이즈 맞추는중
        	  trace("★★★★★★★★★★★★★★★★★★"+this.emp_img.image);


        			}else if(vFile==undefined){

        				  trace('');
        				  trace('');
        				  trace('');
        				  trace('-----------------------there is no image to show----------------------------');
        				  trace('');
        				  trace('');
        				  trace('');

        			}

        	trace('');
        	trace('');
        	trace('');
        	trace('---------------------------add image finished---------------------------');
        	trace('');
        	trace('');
        	trace('');


        };






        //이미지 VirtualFile 오픈 성공
        this.FileList_onsuccess = function(obj,e)   //12. 모달끌떄, 사진을 읽었다면 실행되는 메서드
        {   trace(e.binarydata);
              var findNum = this.ds_img.findRow("EMP_FILE_NAME", empFileName);
              if(findNum > -1){            //13. 해당사원의 프로필사진이 이미 있다면
                 this.ds_img.deleteRow(findNum);   //14. 삭제시킴(새로운걸 넣기위해)
              }

              this.ds_img.addRow();            //15. 위에서 row자체를 삭제시켯으니, 이제 다시 사진을넣을 row만들어서
              //로그인시 세팅한 정보로 넣는방법(계속 admin으로 들어감)
              //16.이줄은 이름 넣는중(사원코드+jpg)
                                         //방안1. this.ds_empList.rowposition   방안2.application.gds_emp   방안3.application.gv_empCode
        	  //저장될 사진의 이름을 설정하는 줄
              this.ds_img.setColumn(0,"EMP_FILE_NAME",application.gds_emp.getColumn(this.ds_empList.rowposition,"EMP_CODE")+".jpg");   //16.이줄은 이름 넣는중(사원코드+jpg) string형태
              this.ds_img.setColumn(0,"IMG_FILE_DATA", e.binarydata);      //17.이줄은 데이터넣는중(2진수의 형태)=  BLOB : 2진수의 자료형
              // 사진과 사진이름을 각각 저장한다.
        	  trace("★★★★★★★★★★★★★"+this.ds_img.getColumn(e.row, "EMP_FILE_NAME"));
        	  trace('<<< data is :'+e.binarydata);
        };






        //수정
        var originEmp1;
        var originEmp2;
        // 수정 버튼을 누르면 수정 버튼의 text가 저장 버튼으로 바뀌고
        // 화면에서 수정이 가능한 컴포넌트의 속성이 readonly = false로 바뀐다.
        this.mod_btn_onclick = function(obj,e)
        {
        	originEmp1=this.edit_emp_code.text;
        	trace(originEmp1);
        	if(originEmp2==undefined?'':originEmp2==originEmp2||originEmp2==undefined){
        		trace('is not same emp');
        	}
        	originEmp1=this.edit_emp_code.text;
        	var modBtn=this.mod_btn.text;
        	this.save_btn.set_visible(false);
        	 this.cancel_btn.set_visible(true);

        	if(modBtn=='수 정'){

        			// 이미지 "첨 부" 버튼을 보이게 하고
        			this.img_btn.set_visible(true);

        			this.mod_btn.set_text('저 장');
        			this.edit_pw.set_readonly(false);
        			this.edit_email.set_readonly(false);
        			this.edit_phone_number.set_readonly(false);
        			this.edit_basic_address.set_readonly(false);

        			//트랜잭션을 보낼 데이터셋에 row를 추가
        			this.data_for_transaction.addRow();
        	trace('<<<<<<<<<< rowCnt is : '+this.data_for_transaction.getRowCount());


        	}else if(modBtn=='저 장'){



        			// 이미지가 있으면은 이미지의 정보를 dataset에 할당
        			if(this.emp_img.image!=undefined){
        				this.data_for_transaction.setColumn(0,'IMAGE',this.emp_img.image);
        				trace('image is : '+this.data_for_transaction.getColumn(0,'IMAGE'));
        				}else if(this.emp_img.image==undefined){
        					trace('------------there is no image ------------');

        				} // 이미지 확인 if문의 끝


        	var userPw=this.edit_pw.value;

        	var email=this.edit_email.text;

        	var phoneNumber=this.edit_phone_number.text;

        	var levelOfEducation=this.edit_level_of_education.value;

        	var basicAddress=this.edit_basic_address.text;


        	if(userPw.trim()==''||userPw.length<7){
        	trace('here--------------------');
        		if(userPw.trim()==''){
        			alert('비밀번호를 입력해 주세요.');
        			return;
        		}else if(userPw.length<7){
        			alert('비밀번호는 7자 이상으로 입력해 주세요.');
        			return;
        		}
         	}else if(email==''){

        		alert('이메일을 입력해 주세요.');
        		return;
        			}
        	var bool=confirm('저장하시겠습니까?');

        		if(bool){
        			//this.data_for_transaction.addRow();

        			//함수를 불러서 해당 함수에서 트랜잭션 진행
        			this.transaction_Func();
        		}else{

        			return;

        		}

        	}



        };


        this.transaction_Func=function(){

        //사진정보를 IMAGE칼럼에 저장




        //그 외의 정보를 각각의 칼럼에 저장

        this.data_for_transaction.setColumn(0,'EMP_CODE',this.edit_emp_code.text);
        this.data_for_transaction.setColumn(0,'EMP_NAME',this.edit_emp_name.text);
        this.data_for_transaction.setColumn(0,'USER_PW',this.edit_pw.text);
        this.data_for_transaction.setColumn(0,'SOCIAL_SECURITY_NUMBER',this.edit_social_security_number.text);
        this.data_for_transaction.setColumn(0,'BIRTH_DATE',this.edit_birth_date.text);
        this.data_for_transaction.setColumn(0,'POSITION_NAME',this.edit_position_name.text);
        this.data_for_transaction.setColumn(0,'DEPT_NAME',this.edit_dept_name.text);
        this.data_for_transaction.setColumn(0,'GENDER',this.edit_gender.text);
        this.data_for_transaction.setColumn(0,'USER_OR_NOT',this.edit_user_or_not.text);
        this.data_for_transaction.setColumn(0,'EMAIL',this.edit_email.text);
        this.data_for_transaction.setColumn(0,'PHONE_NUMBER',this.edit_phone_number.text);
        this.data_for_transaction.setColumn(0,'LEVEL_OF_EDUCATION',this.edit_level_of_education.text);
        this.data_for_transaction.setColumn(0,'BASIC_ADDRESS',this.edit_basic_address.text);



        trace(this.data_for_transaction.getColumn(0,'EMP_CODE'));

        trace('<<<<< this is okay');



              var id = "modifyEmp";
              var url = "svcOperate::modifyEmp";
              var resData ="gds_emp=data_for_transaction";
              var reqData ="";
              var args = "";
              var callback = "modify_emp_callbackFunc";

              this.transaction(id, url, resData, reqData, args, callback);


        	//수정 버튼과 다른 컴포넌트들을 원래의 상태로 돌려 놓는다.

        	this.save_btn.set_visible(true);
        	this.edit_pw.set_readonly(true);
        	this.edit_email.set_readonly(true);
        	this.edit_phone_number.set_readonly(true);
        	this.edit_basic_address.set_readonly(true);
        	this.mod_btn.set_text('수 정');

        }

        this.modify_emp_callbackFunc=function(){

        var deleted_row=this.data_for_transaction.clearData();
        trace('<<<<<<<<<<<<<<<<<< deleted row is : '+deleted_row);
        this.reload();

        }








        //삭제 버튼을 누르면 발생하는 이벤트
        this.del_btn_onclick = function(obj,e)
        {		var empCode=this.edit_emp_code.text;
        		trace('<<<<< empCode is : '+empCode);

        	var bool=confirm('삭제하시겠습니까?')

        	if(bool){
        	//삭제할 empCode를 파라미터로 작성한 트랜잭션을 보내고


        	var id = "removeEmployee";
        	var url = "svcOperate::removeEmp";
        	var resData = "";  // update하거나 insert할때는 res데이터로 :U옵션을 주고 전송
        	var reqData =""; // 데이터 요청
        	var args = "empCode="+nexacro.wrapQuote(empCode);    // nexacro.wrapQuote()를 사용하는 이유는 문자와
        	var callback = "remove_emp_callbackFunc";            // 문자 사이에 공백이 있으면은 공백 다음의 글자를
        														 // 전달이? 되지 않기 때문
        	this.transaction(id, url, resData, reqData, args, callback);


        	alert('삭제되었습니다.');

        	}else{

        	return;
        	}

        };


        this.remove_emp_callbackFunc=function(){

        //트랜잭션이 잘 갔다가 오면은 employeeform을 reload
        this.reload();


        }




        														// 사용하지 않는 코드들





        // 취소 버튼을 누르면은 reload
        this.cancel_btn_onclick = function(obj,e)
        {	var bool=confirm('취소 하시겠습니까?');
        	if(bool){

        			this.reload();

        	}
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.employeeform_onload,this);
            this.Div00.form.deptSerchCombo.addEventHandler("oncloseup",this.deptSerchCombo,this);
            this.Div00.form.deptSerchCombo.addEventHandler("onitemchanged",this.Div00_deptSerchCombo_onitemchanged,this);
            this.Div00.form.emp_information.addEventHandler("oncellclick",this.Div00_emp_information_oncellclick,this);
            this.edit_emp_name.addEventHandler("onchanged",this.Common_onchanged,this);
            this.edit_emp_code.addEventHandler("onchanged",this.empCode_onchanged,this);
            this.mod_btn.addEventHandler("onclick",this.mod_btn_onclick,this);
            this.save_btn.addEventHandler("onclick",this.save_btn_onclick,this);
            this.del_btn.addEventHandler("onclick",this.del_btn_onclick,this);
            this.edit_social_security_number.addEventHandler("onchanged",this.edit_social_security_code_onchanged,this);
            this.img_btn.addEventHandler("onclick",this.img_btn_onclick,this);
            this.cancel_btn.addEventHandler("onclick",this.cancel_btn_onclick,this);
            this.FileDialog.addEventHandler("onclose",this.FileDialog_onclose,this);
            this.VirtualFile00.addEventHandler("onerror",this.VirtualFile00_onerror,this);
            this.VirtualFile00.addEventHandler("onsuccess",this.VirtualFile00_onsuccess,this);
        };
        this.loadIncludeScript("employeeform.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
