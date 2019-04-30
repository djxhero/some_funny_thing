<template>
  <el-form ref="form" :model="student" label-width="80px">

    <el-form-item label="姓名">
      <el-input v-model="student.name"></el-input>
    </el-form-item>

    <el-form-item label="性别">
      <el-radio-group v-model="student.sex">
      <el-radio label="1">男</el-radio>
      <el-radio label="2">女</el-radio>
      </el-radio-group>
    </el-form-item>

    <el-form-item label="年龄">
      <el-input v-model.number="student.age" type="number"></el-input>
    </el-form-item>

    <el-form-item>
    <el-button plain>添加</el-button>
    <el-button plain @click="onBack">返回</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: 'student-add',
  data () {
    return {
      student: {
        name: '',
        sex: '1',
        age: 0
      }
    }
  },
  methods: {
    onBack () {
      this.$router.back()
    }
  }
}
</script>

<style scoped>

</style>
