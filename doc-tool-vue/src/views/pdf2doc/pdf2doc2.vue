<template>
  <el-upload
    class="upload-demo"
    ref="upload"
    action="http://localhost:8089/pdf/pdf2doc"
    :on-preview="handlePreview"
    :on-remove="handleRemove"
    :multiple="false"
    :show-file-list="true"
    :file-list="fileList"
    :on-error="handleError"
    :on-success="handleSuccess"
    drag
    accept=".pdf"
    :auto-upload="false"
    :on-change="handleChange"
  >
    <i class="el-icon-upload"></i>
    <div class="el-upload__text">
      将文件拖到此处，或
      <em>点击上传</em>
    </div>
    <div class="el-upload__tip" slot="tip">只能上传pdf文件，且不超过100MB</div>
    <div class="el-upload__tip" slot="tip">
      <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">开始转换</el-button>
    </div>

    <a id="donwloadLink" target="_blank" style="display:none;"></a>
  </el-upload>
</template>
<style>
.upload-btn {
  margin-top: 7px;
}
</style>

<script>
import axios from "axios";

export default {
  data() {
    return {
      fileList: []
    };
  },
  methods: {
    downloadFile(url, fileName) {
      // console.log(resp);
      document.querySelector('#donwloadLink')
      let link = document.createElement("a");

      link.href = url;
      link.download = fileName;
      link.click();
      console.log(link);
      window.URL.revokeObjectURL(url);
    },
    handleSuccess(response, file) {
      console.log("success");
      console.log(response);
      var that = this;
      try {
        if (response && response.data) {
          // fileList.push()
          // fileList = ;
          that.downloadFile(response.data.url, response.data.name);
          // axios({
          //   method: "get",
          //   url: response.data.url,
          //   responseType: "blob"
          // }).then(function(resp) {
          //   var blob = new Blob([resp.data], { type: "octet/stream" });
          //   var url = window.URL.createObjectURL(blob);
          //   that.downloadFile(url, response.data.name);
          // });
        } else {
          this.$message.error("转换失败");
        }
      } catch (e) {
        console.log(e);
      }
    },
    submitUpload() {
      this.$refs.upload.submit();
    },
    handleError(file) {
      this.$message.error("上传出错");
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log("preview");
    },
    // handleExceed(files, fileList) {
    //   this.$message.warning(
    //     `当前限制选择 1 个文件，本次选择了 ${
    //       files.length
    //     } 个文件，共选择了 ${files.length + fileList.length} 个文件`
    //   );
    // },
    handleChange(file, fileList) {
      console.log("change");
      fileList = fileList.slice(-1);
      console.log(fileList.length);
      this.fileList = fileList;
    }
  }
};
</script>
  
