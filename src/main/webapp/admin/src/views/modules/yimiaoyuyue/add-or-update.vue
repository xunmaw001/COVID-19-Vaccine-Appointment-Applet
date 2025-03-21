<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row >
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'" label="预约编号" prop="yuyuebianhao">
            <el-input v-model="ruleForm.yuyuebianhao" 
                placeholder="预约编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.yuyuebianhao" label="预约编号" prop="yuyuebianhao">
              <el-input v-model="ruleForm.yuyuebianhao" 
                placeholder="预约编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="疫苗名称" prop="yimiaomingcheng">
          <el-input v-model="ruleForm.yimiaomingcheng" 
              placeholder="疫苗名称" clearable  :readonly="ro.yimiaomingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="疫苗名称" prop="yimiaomingcheng">
              <el-input v-model="ruleForm.yimiaomingcheng" 
                placeholder="疫苗名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.fengmiantupian" label="封面图片" prop="fengmiantupian">
          <file-upload
          tip="点击上传封面图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.fengmiantupian?ruleForm.fengmiantupian:''"
          @change="fengmiantupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fengmiantupian" label="封面图片" prop="fengmiantupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fengmiantupian.split(',')" :src="$base.url+item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="疫苗分类" prop="yimiaofenlei">
          <el-input v-model="ruleForm.yimiaofenlei" 
              placeholder="疫苗分类" clearable  :readonly="ro.yimiaofenlei"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="疫苗分类" prop="yimiaofenlei">
              <el-input v-model="ruleForm.yimiaofenlei" 
                placeholder="疫苗分类" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="接种地点" prop="jiezhongdidian">
          <el-input v-model="ruleForm.jiezhongdidian" 
              placeholder="接种地点" clearable  :readonly="ro.jiezhongdidian"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="接种地点" prop="jiezhongdidian">
              <el-input v-model="ruleForm.jiezhongdidian" 
                placeholder="接种地点" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="接种时间" prop="jiezhongshijian">
          <el-input v-model="ruleForm.jiezhongshijian" 
              placeholder="接种时间" clearable  :readonly="ro.jiezhongshijian"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="接种时间" prop="jiezhongshijian">
              <el-input v-model="ruleForm.jiezhongshijian" 
                placeholder="接种时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="适合人群" prop="shiherenqun">
          <el-input v-model="ruleForm.shiherenqun" 
              placeholder="适合人群" clearable  :readonly="ro.shiherenqun"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="适合人群" prop="shiherenqun">
              <el-input v-model="ruleForm.shiherenqun" 
                placeholder="适合人群" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="疫苗数量" prop="yimiaoshuliang">
          <el-select :disabled="ro.yimiaoshuliang" v-model="ruleForm.yimiaoshuliang" placeholder="请选择疫苗数量">
            <el-option
                v-for="(item,index) in yimiaoshuliangOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="疫苗数量" prop="yimiaoshuliang">
	      <el-input v-model="ruleForm.yimiaoshuliang"
                placeholder="疫苗数量" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="接种费用" prop="jiezhongfeiyong">
          <el-input v-model="ruleForm.jiezhongfeiyong" 
              placeholder="接种费用" clearable  :readonly="ro.jiezhongfeiyong"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="接种费用" prop="jiezhongfeiyong">
              <el-input v-model="ruleForm.jiezhongfeiyong" 
                placeholder="接种费用" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="预约时间" prop="yuyueshijian">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.yuyueshijian" 
                type="datetime"
                :readonly="ro.yuyueshijian"
                placeholder="预约时间">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.yuyueshijian" label="预约时间" prop="yuyueshijian">
              <el-input v-model="ruleForm.yuyueshijian" 
                placeholder="预约时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="用户账号" prop="yonghuzhanghao">
          <el-input v-model="ruleForm.yonghuzhanghao" 
              placeholder="用户账号" clearable  :readonly="ro.yonghuzhanghao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="用户账号" prop="yonghuzhanghao">
              <el-input v-model="ruleForm.yonghuzhanghao" 
                placeholder="用户账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuxingming">
          <el-input v-model="ruleForm.yonghuxingming" 
              placeholder="用户姓名" clearable  :readonly="ro.yonghuxingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="用户姓名" prop="yonghuxingming">
              <el-input v-model="ruleForm.yonghuxingming" 
                placeholder="用户姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling" 
              placeholder="年龄" clearable  :readonly="ro.nianling"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="年龄" prop="nianling">
              <el-input v-model="ruleForm.nianling" 
                placeholder="年龄" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="性别" prop="xingbie">
          <el-input v-model="ruleForm.xingbie" 
              placeholder="性别" clearable  :readonly="ro.xingbie"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="性别" prop="xingbie">
              <el-input v-model="ruleForm.xingbie" 
                placeholder="性别" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="备注" prop="beizhu">
          <el-input v-model="ruleForm.beizhu" 
              placeholder="备注" clearable  :readonly="ro.beizhu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="备注" prop="beizhu">
              <el-input v-model="ruleForm.beizhu" 
                placeholder="备注" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      </el-row>
      <el-form-item class="btn">
        <el-button  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"rgba(0, 0, 0, 1)","selectFontSize":"16px","btnCancelBorderColor":"rgba(188, 188, 188, 1)","inputBorderRadius":"0","inputFontSize":"16px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"0","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"0","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"rgba(0, 0, 0, 1)","addEditBoxColor":"#fff","dateIconFontSize":"16px","btnSaveBgColor":"rgba(219, 244, 255, 1)","uploadIconFontColor":"rgba(0, 0, 0, 1)","textareaBorderColor":"rgba(112, 112, 112, 1)","btnCancelBgColor":"rgba(241, 241, 241, 1)","selectLableColor":"rgba(0, 0, 0, 1)","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"0","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"rgba(0, 0, 0, 1)","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"rgba(0, 0, 0, 1)","dateBorderColor":"rgba(112, 112, 112, 1)","dateIconFontColor":"rgba(0, 0, 0, 1)","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"rgba(0, 0, 0, 1)","dateFontSize":"16px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"rgba(0, 0, 0, 1)","uploadHeight":"148px","textareaLableColor":"rgba(0, 0, 0, 1)","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"0","inputBgColor":"#fff","inputLableFontSize":"14px","uploadLableColor":"rgba(0, 0, 0, 1)","uploadBorderRadius":"0","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"16px","dateHeight":"40px","selectBorderColor":"rgba(112, 112, 112, 1)","inputBorderColor":"rgba(112, 112, 112, 1)","uploadBorderColor":"rgba(112, 112, 112, 1)","textareaFontColor":"rgba(0, 0, 0, 1)","selectBorderWidth":"1px","dateFontColor":"#606266","btnCancelBorderWidth":"0 5px 5px","uploadBorderWidth":"1px","textareaFontSize":"16px","selectBorderRadius":"0","selectFontColor":"rgba(0, 0, 0, 1)","btnSaveBorderColor":"rgba(109, 109, 148, 1)","btnSaveBorderWidth":"0 5px 5px"},
      id: '',
      type: '',
      ro:{
	yuyuebianhao : false,
	yimiaomingcheng : false,
	fengmiantupian : false,
	yimiaofenlei : false,
	jiezhongdidian : false,
	jiezhongshijian : false,
	shiherenqun : false,
	yimiaoshuliang : false,
	jiezhongfeiyong : false,
	yuyueshijian : false,
	yonghuzhanghao : false,
	yonghuxingming : false,
	nianling : false,
	xingbie : false,
	beizhu : false,
	sfsh : false,
	shhf : false,
	ispay : false,
	userid : false,
      },
      ruleForm: {
        yuyuebianhao: this.getUUID(),
        yimiaomingcheng: '',
        fengmiantupian: '',
        yimiaofenlei: '',
        jiezhongdidian: '',
        jiezhongshijian: '',
        shiherenqun: '',
        yimiaoshuliang: '',
        jiezhongfeiyong: '',
        yuyueshijian: '',
        yonghuzhanghao: '',
        yonghuxingming: '',
        nianling: '',
        xingbie: '',
        beizhu: '',
        shhf: '',
        userid: '',
      },
          yimiaoshuliangOptions: [],
      rules: {
          yuyuebianhao: [
          ],
          yimiaomingcheng: [
          ],
          fengmiantupian: [
          ],
          yimiaofenlei: [
          ],
          jiezhongdidian: [
          ],
          jiezhongshijian: [
          ],
          shiherenqun: [
          ],
          yimiaoshuliang: [
                { required: true, message: '疫苗数量不能为空', trigger: 'blur' },
          ],
          jiezhongfeiyong: [
          ],
          yuyueshijian: [
          ],
          yonghuzhanghao: [
          ],
          yonghuxingming: [
          ],
          nianling: [
          ],
          xingbie: [
          ],
          beizhu: [
          ],
          sfsh: [
          ],
          shhf: [
          ],
          ispay: [
          ],
          userid: [
          ],
      }
    };
  },
  props: ["parent"],
  computed: {



  },
  created() {
	this.ruleForm.yuyueshijian = this.getCurDateTime()

	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='logistics'){
        this.logistics=false;
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          if(o=='yuyuebianhao'){
            this.ruleForm.yuyuebianhao = obj[o];
	    this.ro.yuyuebianhao = true;
            continue;
          }
          if(o=='yimiaomingcheng'){
            this.ruleForm.yimiaomingcheng = obj[o];
	    this.ro.yimiaomingcheng = true;
            continue;
          }
          if(o=='fengmiantupian'){
            this.ruleForm.fengmiantupian = obj[o];
	    this.ro.fengmiantupian = true;
            continue;
          }
          if(o=='yimiaofenlei'){
            this.ruleForm.yimiaofenlei = obj[o];
	    this.ro.yimiaofenlei = true;
            continue;
          }
          if(o=='jiezhongdidian'){
            this.ruleForm.jiezhongdidian = obj[o];
	    this.ro.jiezhongdidian = true;
            continue;
          }
          if(o=='jiezhongshijian'){
            this.ruleForm.jiezhongshijian = obj[o];
	    this.ro.jiezhongshijian = true;
            continue;
          }
          if(o=='shiherenqun'){
            this.ruleForm.shiherenqun = obj[o];
	    this.ro.shiherenqun = true;
            continue;
          }
          if(o=='yimiaoshuliang'){
            this.ruleForm.yimiaoshuliang = obj[o];
	    this.ro.yimiaoshuliang = true;
            continue;
          }
          if(o=='jiezhongfeiyong'){
            this.ruleForm.jiezhongfeiyong = obj[o];
	    this.ro.jiezhongfeiyong = true;
            continue;
          }
          if(o=='yuyueshijian'){
            this.ruleForm.yuyueshijian = obj[o];
	    this.ro.yuyueshijian = true;
            continue;
          }
          if(o=='yonghuzhanghao'){
            this.ruleForm.yonghuzhanghao = obj[o];
	    this.ro.yonghuzhanghao = true;
            continue;
          }
          if(o=='yonghuxingming'){
            this.ruleForm.yonghuxingming = obj[o];
	    this.ro.yonghuxingming = true;
            continue;
          }
          if(o=='nianling'){
            this.ruleForm.nianling = obj[o];
	    this.ro.nianling = true;
            continue;
          }
          if(o=='xingbie'){
            this.ruleForm.xingbie = obj[o];
	    this.ro.xingbie = true;
            continue;
          }
          if(o=='beizhu'){
            this.ruleForm.beizhu = obj[o];
	    this.ro.beizhu = true;
            continue;
          }
          if(o=='userid'){
            this.ruleForm.userid = obj[o];
	    this.ro.userid = true;
            continue;
          }
        }
        this.ruleForm.yimiaoshuliang = 0
	    this.ro.yimiaoshuliang = false;
      }
      // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
		if(json.yonghuzhanghao!=''&&json.yonghuzhanghao){
                this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
	    		this.ro.yonghuzhanghao = true;
		}
		if(json.yonghuxingming!=''&&json.yonghuxingming){
                this.ruleForm.yonghuxingming = json.yonghuxingming
	    		this.ro.yonghuxingming = true;
		}
		if(json.nianling!=''&&json.nianling){
                this.ruleForm.nianling = json.nianling
	    		this.ro.nianling = true;
		}
		if(json.xingbie!=''&&json.xingbie){
                this.ruleForm.xingbie = json.xingbie
	    		this.ro.xingbie = true;
		}
        } else {
          this.$message.error(data.msg);
        }
      });
            this.yimiaoshuliangOptions = "1".split(',')
    },
    // 多级联动参数
    info(id) {
      this.$http({
        url: `yimiaoyuyue/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {






	if(this.ruleForm.fengmiantupian!=null) {
		this.ruleForm.fengmiantupian = this.ruleForm.fengmiantupian.replace(new RegExp(this.$base.url,"g"),"");
	}

































var objcross = this.$storage.getObj('crossObj');
      var table = this.$storage.getObj('crossTable');
      if(objcross!=null) {
	      objcross.yimiaoshuliang = objcross.yimiaoshuliang - this.ruleForm.yimiaoshuliang
	      if(objcross.yimiaoshuliang<0){
		this.$message.error("疫苗数量不足");
		return
	      }
                }

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(!statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                              this.$http({
                                  url: `${table}/update`,
                                  method: "post",
                                  data: objcross
                                }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "yimiaoyuyue/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `yimiaoyuyue/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.yimiaoyuyueCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
                      this.$http({
                          url: `${table}/update`,
                          method: "post",
                          data: objcross
                        }).then(({ data }) => {});
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `yimiaoyuyue/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
                  this.$http({
                      url: `${table}/update`,
                      method: "post",
                      data: objcross
                    }).then(({ data }) => {});
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.yimiaoyuyueCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.yimiaoyuyueCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    fengmiantupianUploadChange(fileUrls) {
	this.ruleForm.fengmiantupian = fileUrls;
	this.addEditUploadStyleChange()
    },
	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}
</style>
