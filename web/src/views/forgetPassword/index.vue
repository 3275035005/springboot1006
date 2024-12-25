<template>
  <div class="app-container">
    <template>
      <div class="app-container">
        <el-form label-width="120px">
          <el-form-item label="学号">
            <el-input v-model="dataVo.username" placeholder="请填写学号"/>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input v-model="dataVo.name" placeholder="请填写姓名"/>
          </el-form-item>
          <el-form-item label="性别">
            <el-select v-model="dataVo.sex" placeholder="请选择性别">
              <el-option label="女" value="0"></el-option>
              <el-option label="男" value="1"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="联系方式">
            <el-input v-model="dataVo.phone" placeholder="请填写联系方式"/>
          </el-form-item>
          <el-form-item label="新密码">
            <el-input type="password" v-model="dataVo.password" placeholder="请填写联系方式"/>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="forgetPasswords">找回密码</el-button>
          </el-form-item>
        </el-form>
      </div>
    </template>
  </div>
</template>

<script>
import {forgetPassword} from '@/api/user'
import {getToken} from '@/utils/auth'

export default {
  data() {

    return {
      dataVo: {
        username:'',
        name:'',
        sex:'',
        phone:'',
        password:'',
      }
    }
  },
  methods: {
    forgetPasswords() {
      forgetPassword(this.dataVo)
        .then(response => {
          if (response.code === 20000) {
            // 提示信息
            this.$message({
              type: 'success',
              message: '找回成功'
            });
          } else {
            // 提示信息
            this.$message({
              type: 'error',
              message: response.message
            });
          }
          this.dataVo = {}
        })
    }
  },

}
</script>
