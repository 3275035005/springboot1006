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
          <el-form-item label="我的班级">
            <el-select
              v-model="dataVo.classs"
              placeholder="请选择我的班级"
            >
              <el-option
                v-for="item in classList"
                :key="item.id"
                :label="item.className"
                :value="item.id"
              />
            </el-select>
          </el-form-item>

          <el-form-item label="新密码">
            <el-input type="password" v-model="dataVo.password" placeholder="请填写联系方式"/>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="registers">注册</el-button>
          </el-form-item>
        </el-form>
      </div>
    </template>
  </div>
</template>

<script>
import {register} from '@/api/user'
import { getClassAll } from '@/api/class'

export default {
  data() {

    return {
      dataVo: {
        username:'',
        name:'',
        sex:'',
        phone:'',
        password:'',

      },
      classList:[]
    }
  },
  created() {
    this.init();
  },
  methods: {
    init(){
      getClassAll().then(res=>{
        this.classList = res.data.data
      })
    },
    registers() {
      register(this.dataVo)
        .then(response => {
          if (response.code === 20000) {
            // 提示信息
            this.$message({
              type: 'success',
              message: '注册成功，请返回登录'
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
