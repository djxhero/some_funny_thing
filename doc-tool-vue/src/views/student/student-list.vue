<template>
  <el-table
    :data="tableData"
    stripe
    style="width: 100%">
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="sex"
      label="性别"
      width="180">
    </el-table-column>
    <el-table-column
      prop="age"
      label="年龄">
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: 'student-list',
  data () {
    return {
      tableData: [{
        name: '张楚岚',
        sex: '男',
        age: '23'
      },
      {
        name: '冯宝宝',
        sex: '女',
        age: '99'
      },
      {
        name: '赵方旭',
        sex: '男',
        age: '59'
      },
      {
        name: '肖自在',
        sex: '36',
        age: '男'
      }
      ]
    }
  }
}
</script>

<style scoped>

</style>