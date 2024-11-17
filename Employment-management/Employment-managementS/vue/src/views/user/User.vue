<template>
    <div>
        <!--搜索表单-->
        <div style="margin-bottom: 20px">
            <i class="el-icon-user-solid" style="margin-right: 5px"></i>
            <el-input style="width: 240px" placeholder="请输入姓名" v-model="params.name"></el-input>   <!--绑定变量-->
            <i class="el-icon-s-promotion" style="margin-right: 5px"></i>
            <el-input style="width: 260px;margin-left: 5px" placeholder="请输入联系方式" v-model="params.phone"></el-input>
            <el-button style="margin-left: 5px" type="primary" @click="load"><i class="el-icon-search"></i>搜索</el-button>   <!--还得绑定事件！！！-->
            <el-button style="margin-left: 5px" type="warning" @click="reset"><i class="el-icon-refresh"></i>重置</el-button>   <!--重置按钮-->
        </div>
        <el-table :data="tableData" stripe>
            <el-table-column prop="id" label="序号" width="50px" ></el-table-column>
            <el-table-column prop="department" label="隶属学院"></el-table-column>
            <el-table-column prop="name" label="姓名"></el-table-column>
            <el-table-column prop="major" label="专业"></el-table-column>
            <el-table-column prop="sex" label="性别"></el-table-column>
            <el-table-column prop="age" label="年龄"></el-table-column>
            <el-table-column prop="address" label="就业城市"></el-table-column>
            <el-table-column prop="company" label="工作单位"></el-table-column>
            <el-table-column prop="phone" label="联系方式"></el-table-column>


<!--            <el-table-column prop="createtime" label="创建时间"></el-table-column>-->
<!--            <el-table-column prop="updatetime" label="更新时间"></el-table-column>-->

            <el-table-column label="操作" width="230px">
                <template v-slot="scope">
<!--                    scope.row就是当前行数据-->
                    <el-button type="primary" @click="$router.push('/editUser?id=' + scope.row.id)">编辑</el-button>
                    <el-popconfirm
                            style="margin-left: 5px"
                            title="您确定删除这行信息吗？"
                            @confirm="del(scope.row.id)"
                    >
                        <el-button type="danger" slot="reference">删除</el-button>
                    </el-popconfirm>
                    <el-button type="info" @click="$router.push('/userDetails?id=' + scope.row.id)" style="margin-left: 5px">详情</el-button>
                </template>
            </el-table-column>
        </el-table>
        <!--分页-->
        <div style="margin-top: 20px">
            <el-pagination
                    background
                    :current-page="params.pageNum"
                    :page-size="params.pageSize"
                    layout="prev, pager, next"
                    @current-change="handleCurrentChange"
                    :total="total">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    import request from "@/utils/request";

    export default {
        name: 'User',
        data() {
            return {
                tableData: [],
                total: 0,
                params: {
                    pageNum: 1,
                    pageSize: 10,
                    name: '',
                    phone: ''
                }
            }
        },
        created() {
            this.load()
        },
        methods: {
            load() {
                // fetch('http://localhost:9091/user/list').then(res => res.json()).then(res =>{
                //   console.log(res)
                //   this.tableData = res
                // })


                request.get('/user/page',{
                    params: this.params
                }).then(res => {
                    if (res.code === '200'){
                        this.tableData = res.data.list
                        this.total = res.data.total
                    }
                })
            },
            reset() {
                this.params = {
                    pageNum: 1,
                    pageSize: 10,
                    name: '',
                    phone: ''
                }
                this.load()
            },
            handleCurrentChange(pageNum) {
                //点击分页按钮触发分页
                this.params.pageNum = pageNum
                this.load()
            },
            del(id) {            //定义一个del这样的方法去调用后台的接口
                request.delete("/user/delete/" + id).then(res => {
                    if (res.code === '200'){
                        this.$notify.success('删除成功')
                        this.load()
                    } else {
                        this.$notify.error(res.msg)

                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>