<template>
    <div style="width: 80%">
        <div style="margin-bottom: 30px">新增毕业生信息</div>
        <el-form ref="ruleForm"  :inline="true" :model="form":rules="rules" label-width="150px" >
            <el-form-item label="姓名" prop="name">              <!--绑定字段-->
                <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
            </el-form-item>
            <el-form-item label="年龄" prop="age">              <!--绑定字段-->
                <el-input v-model="form.age" placeholder="请输入年龄"></el-input>
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
            <el-form-item label="就业城市" prop="address">              <!--绑定字段-->
                <el-input v-model="form.address" placeholder="请输入就业城市"></el-input>
            </el-form-item>
            <el-form-item label="工作单位" prop="company">              <!--绑定字段-->
                <el-input v-model="form.company" placeholder="请输入工作单位"></el-input>
            </el-form-item>
            <el-form-item label="联系方式" prop="phone">              <!--绑定字段-->
                <el-input v-model="form.phone" placeholder="请输入联系方式"></el-input>
            </el-form-item>

        </el-form>
        <div style="text-align: center;margin-top: 30px">
            <el-button type="primary" @click="save" size="medium">提交</el-button>
<!--            <el-button type="danger" >返回列表</el-button>-->
        </div>
    </div>
</template>


<script>
    import request from "@/utils/request";
    export default {
        name: 'AddUser',
        data() {
            const checkAge = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('年龄不能为空'));
                }
                console.log(typeof value)
                if (!/^[0-9]+$/.test(value)) {
                    callback(new Error('请输入数字值'));
                }
                if(parseInt(value) > 120 || parseInt(value) <= 0) {
                    callback(new Error('请输入合理的年龄'));
                }
                callback()
            };
            const checkPhone = (rule, value, callback) => {
                if (!/^[1][3,4,5,6,7,8,9][0-9]{9}$/.test(value)) {
                    callback(new Error('请输入合法的手机号'));
                }
                callback()
            };
            return {
                form: { sex: '男' },
                rules: {
                    name: [
                        {required: true, message: '请输入姓名', trigger: 'blur'},
                        {min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur'}
                    ],
                    department: [
                        {required: true, message: '请输入学院名', trigger: 'blur'},
                    ],
                    major: [
                        {required: true, message: '请输入专业名称', trigger: 'blur'},
                    ],
                    age: [
                        {validator: checkAge, trigger: 'blur'}
                    ],
                    phone: [
                        {validator: checkPhone, trigger: 'blur'}
                    ],

                },
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