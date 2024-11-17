<template>
    <div>
        <!--头部区域-->
        <div style="height: 60px;line-height: 60px;background-color: white;margin-bottom: 2px; display: flex">
            <div style="width: 400px">
                <img src="@/assets/270.jpg"alt=""style="width: 40px;height: 40px;position: relative;top: 10px;left: 20px">
                <span style="margin-left: 25px;font-size: 24px; left: 20px">高校毕业生就业信息管理系统</span>
            </div >
            <div style="flex: 1; text-align: right; padding-right: 20px">     <!--   flex:1 除了300px的之外的都属于他   -->
                <el-dropdown size: medium>
                    <span class="el-dropdown-link" style="cursor: pointer">
                        {{ admin.username }}<i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown" style="margin-top: -5px">
                        <el-dropdown-item>
                            <div style="width: 50px;text-align: center" @click="logout">
                                退出
                            </div>
                        </el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
        </div>
        <!--侧边栏和主体-->
        <div style="display: flex">
            <!--侧边栏导航-->                                                <!--default-openeds当前默认打开的菜单-->
            <div style="width: 200px;min-height: calc(100vh - 62px);overflow: hidden;margin-right: 2px;background-color: white">
                <el-menu :default-active="$route.path" router class="el-menu-demo">
                    <el-menu-item index="/">                              <!--这边的1指代你想默认打开的页面-->
                        <i class="el-icon-eleme"></i>
                        <span>首页</span>
                    </el-menu-item>

                    <el-submenu index="user">                                <!--就是这个要默认打开的1！-->
                        <template slot="title">
                            <i class="el-icon-star-on"></i>
                            <span>毕业生管理</span>
                        </template>
                        <el-menu-item index="/addUser">就业信息添加</el-menu-item>   <!--可以通过index切换页面-->
                        <el-menu-item index="/addGraduateStu">研究生信息添加</el-menu-item>
                        <el-menu-item index="/userList">就业信息列表</el-menu-item>   <!--可以通过index切换页面-->
                        <el-menu-item index="/graduateList">研究生信息列表</el-menu-item>   <!--可以通过index切换页面-->

                    </el-submenu>

                    <el-submenu index="admin">
                        <template slot="title">
                            <i class="el-icon-user"></i>
                            <span>管理员管理</span>
                        </template>
                        <el-menu-item index="/addAdmin">管理员添加</el-menu-item>   <!--可以通过index切换页面-->
                        <el-menu-item index="/adminList">管理员列表</el-menu-item>   <!--可以通过index切换页面-->
                    </el-submenu>

                    <el-submenu index="category">
                        <template slot="title">
                            <i class="el-icon-s-operation"></i>
                            <span>职业分类管理</span>
                        </template>
                        <el-menu-item index="/addCategory">职业分类添加</el-menu-item>   <!--可以通过index切换页面-->
                        <el-menu-item index="/categoryList">职业分类列表</el-menu-item>   <!--可以通过index切换页面-->
                    </el-submenu>

                    <el-submenu index="category">
                        <template slot="title">
                            <i class="el-icon-open"></i>
                            <span>已就业管理</span>
                        </template>
                        <el-menu-item index="/addCategory">已就业信息添加</el-menu-item>   <!--可以通过index切换页面-->
                        <el-menu-item index="/categoryList">已就业信息列表</el-menu-item>   <!--可以通过index切换页面-->
                    </el-submenu>
                    <el-submenu index="category">
                        <template slot="title">
                            <i class="el-icon-turn-off"></i>
                            <span>未就业信息管理</span>
                        </template><!--可以通过index切换页面-->
                        <el-menu-item index="/categoryList">未就业信息列表</el-menu-item>   <!--可以通过index切换页面-->
                    </el-submenu>

                </el-menu>
            </div>
            <!--主体数据-->
            <div style="flex: 1;background-color: white;padding: 10px">
                <router-view/>

            </div>

        </div>
    </div>
    
</template>

<script>
    import Cookies from 'js-cookie';

    export default {
        name: "Layout",
        data() {
            return {
                admin: Cookies.get('admin') ? JSON.parse(Cookies.get('admin')) : {}   //三步表达式判断
            }
        },
        methods: {
            logout() {
                Cookies.remove('admin')
                this.$router.push('/login')
                //清除浏览器用户数据

            }
        }
    }
</script>

<style scoped>

</style>