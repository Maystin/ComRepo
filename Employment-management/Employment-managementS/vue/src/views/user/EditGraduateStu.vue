<template>
    <div style="width: 80%">
        <div style="margin-bottom: 30px">编辑研究生信息</div>
        <el-form :inline="true" :model="form" label-width="150px" >
            <el-form-item label="姓名">              <!--绑定字段-->
                <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
            </el-form-item>
            <el-form-item label="毕业年份">              <!--绑定字段-->
                <el-input v-model="form.gyear" placeholder="请输入毕业年份"></el-input>
            </el-form-item>
            <el-form-item label="性别">              <!--绑定字段-->
                <el-radio v-model="form.sex" label="男">男</el-radio>     <!--单选框-->
                <el-radio v-model="form.sex" label="女">女</el-radio>
            </el-form-item>
            <el-form-item label="隶属学院" prop="department">
                <el-select  v-model="form.department" placeholder="请选择二级学院">
                    <el-option
                            v-for="item in options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="专业" prop="major">              <!--绑定字段-->
                <el-input v-model="form.major" placeholder="请输入您的专业"></el-input>
            </el-form-item>
            <el-form-item label="读研院校" prop="university">              <!--绑定字段-->
                <el-input v-model="form.university" placeholder="请输入读研院校"></el-input>
            </el-form-item>
            <el-form-item label="学号" prop="number">              <!--绑定字段-->
                <el-input v-model="form.number" placeholder="请输入学号"></el-input>
            </el-form-item>
            <el-form-item label="联系方式">              <!--绑定字段-->
                <el-input v-model="form.phone" placeholder="请输入联系方式"></el-input>
            </el-form-item>
        </el-form>
        <div style="text-align: center;margin-top: 30px">
            <el-button type="primary" @click="save" size="medium">提交</el-button>
        </div>
    </div>
</template>


<script>
    import request from "@/utils/request";
    export default {
        name: 'EditGraduate',
        data() {
            return {
                form: {sex:''},
                options: [{
                    value: '教育学院',
                    label: ''
                }, {
                    value: '数理学院',
                    label: ''
                }, {
                    value: '生物科学与工程学院',
                    label: ''
                }, {
                    value: '海洋学院',
                    label: ''
                }, {
                    value: '新能源与材料学院',
                    label: ''
                }, {
                    value: '信息工程学院',
                    label: ''
                }, {
                    value: '机电工程学院',
                    label: ''
                }, {
                    value: '经济管理学院',
                    label: ''
                }, {
                    value: '旅游管理学院',
                    label: ''
                }, {
                    value: '语言文化学院',
                    label: ''
                }, {
                    value: '马克思主义学院',
                    label: ''
                }, {
                    value: '体育学院',
                    label: ''
                }, {
                    value: '医学院',
                    label: ''
                }, {
                    value: '继续教育学院',
                    label: ''
                }, {
                    value: '海外教育学院（海峡学院）',
                    label: ''
                }],
                value: ''
            }
        },
        created() {
            const id = this.$route.query.id
          request.get("/graduateStu/" + id).then(res => {
              this.form = res.data
          })
        },
        methods: {
            save() {
                request.put('/graduateStu/update', this.form).then(res =>{
                    if(res.code === '200') {
                        this.$notify.success('更新成功')
                        this.$router.push("/graduateList")
                    } else {
                        this.$notify.error(res.msg)  //把后台反应的错误打印出来

                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>