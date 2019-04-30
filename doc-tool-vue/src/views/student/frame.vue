<template>
  <el-container>
    <el-header>
      <el-menu
        class="el-menu-demo"
        mode="horizontal"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-submenu index="1">
          <template slot="title">学员管理</template>
          <el-menu-item index="1-1"><router-link :to="{ name: 'StudentList' }"  tag="div">学员列表</router-link></el-menu-item>
          <el-menu-item index="1-2"><router-link :to="{ name: 'CreateStudent' }" tag="div">添加学员</router-link></el-menu-item>
        </el-submenu>
      </el-menu>
    </el-header>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>

</template>

<script>
import studentAdd from './student-add'
import studentList from './student-list'

export default {
  name: 'frame',
  components: {
    studentAdd,
    studentList
  }
}
</script>

<style scoped>

</style>
