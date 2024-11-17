<template>
    <div style="width: 80%">
        <div style="margin-bottom: 30px"></div>
        <el-form ref="ruleForm"  :inline="true" :model="form":rules="rules" label-width="150px" >
<!--            <el-form-item label="年龄" prop="age">              &lt;!&ndash;绑定字段&ndash;&gt;-->
<!--                <el-input v-model="form.age" placeholder="请输入年龄"></el-input>-->
<!--            </el-form-item>-->
            <el-descriptions class="margin-top" title="基本信息" :column="3" :size="size" border>
                <template slot="extra">
                    <el-button type="primary" size="small">操作</el-button>
                </template>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-user"></i>用户名
                    </template>
                    kooriookami
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-mobile-phone"></i>手机号
                    </template>
                    18100000000
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-location-outline"></i>居住地
                    </template>
                    苏州市
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-tickets"></i>备注
                    </template>
                    <el-tag size="small">学校</el-tag>
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-office-building"></i>联系地址
                    </template>
                    江苏省苏州市吴中区吴中大道 1188 号
                </el-descriptions-item>
            </el-descriptions>
        </el-form>
    </div>
</template>


<script>
    import request from "@/utils/request";
    export default {
        name: 'UserDetails',
        data() {

            return {
                form: { sex: '男' },
                rules: {
                    name: [
                        {required: true, message: '请输入姓名', trigger: 'blur'},
                        {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                    ],
                    department: [
                        {required: true, message: '请输入学院名', trigger: 'blur'},
                    ],
                    age: [
                        {validator: checkAge, trigger: 'blur'}
                    ],
                    phone: [
                        {validator: checkPhone, trigger: 'blur'}
                    ],

                },

            }
        },
        methods: {
            save() {
               this.$refs['ruleForm'].validate((valid) => {
                   if (valid) {
                       request.post('/user/save', this.form).then(res =>{
                           if(res.code === '200') {
                               this.$notify.success('新增成功')
                               this.$refs['ruleForm'].resetFields()
                           } else {
                               this.$notify.error(res.msg)  //把后台反应的错误打印出来
                           }
                       })
                   }
               })

            }
        }
    }
</script>

<style scoped>

</style>
