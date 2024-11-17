import axios from "axios";
import router from "@/router";
import Cookies from 'js-cookie';

const request = axios.create({
    baseURL: 'http://localhost:9091/api',
    timeout: 5000
})


request.interceptors.request.use(config=>{
    config.headers['Content-Type'] = 'application/json;charset=utf-8';
    // 拦截器使其跳转到登录界面
    const adminJson = Cookies.get('admin')
    if (adminJson) {
        //设置请求头
        config.headers['token'] = JSON.parse(adminJson).token;
    }

    return config
}, error => {
    return Promise.reject(error)
});

// response 拦截器
// 可以在接口响应后统一处理结果
request.interceptors.response.use(
    response => {
        let res = response.data;
        //兼容服务端返回的字符串数据
        if (typeof res === 'string') {
            res = res ? JSON.parse(res) : res
        }
        if (res.code === '401') {
            router.push('/login')
        }
        return res;
    },
    error => {
        console.log('err' + error)
        return Promise.reject(error)
    }
)


export default request