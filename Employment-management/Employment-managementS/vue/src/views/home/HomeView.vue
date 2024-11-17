<!--<template>-->
<!--  <div>-->
<!--    主页-->
<!--    <div class="item">用户名：{{ admin.username }}</div>-->
<!--    <div class="item">手机号：{{ admin.phone }}</div>-->
<!--    <div class="item">邮箱：{{ admin.email }}</div>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--  import Cookies from 'js-cookie';-->
<!--  import request from "@/utils/request";-->

<!--    export default {-->
<!--      data() {-->
<!--        return {-->
<!--          admin: Cookies.get('admin') ? JSON.parse(Cookies.get('admin')) : {}   //三步表达式判断-->
<!--        }-->
<!--      },-->
<!--      created() {-->
<!--        // request.get('/admin/' + this.admin.id).then(res => {-->
<!--        //   this.admin = res.data-->
<!--        // })-->
<!--      }-->
<!--    }-->


<!--</script>-->

<!--<style>-->
<!--  .item {-->
<!--    margin: 10px 0;-->
<!--    color: #666;-->
<!--  }-->
<!--</style>-->
<template>
  <div>
    <div style="margin: 20px 0">
      <el-select class="input" v-model="timeRange" placeholder="请选择" @change="load">
        <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
        </el-option>
      </el-select>
    </div>
    <el-card>
      <div id="line" style="width: 100%; height: 400px"></div>
    </el-card>
  </div>
</template>

<script>
  import Cookies from 'js-cookie'
  import request from "@/utils/request";
  import * as echarts from 'echarts'

  const option = {
    title: {
      text: '毕业生就业统计'
    },
    tooltip: {
      trigger: 'axis'
    },
    legend:{
      data: ['大学生就业人数','研究生就业人数']
    },
    grid: {
      left: '3%',
      right: '4%',
      bottom: '3%',
      containLabel: true
    },
    toolbox: {
      feature: {
        saveAsImage: {}
      }
    },
    xAxis: {
      type: 'category',
      boundaryGap: false,
      data: []
    },
    yAxis: {
      type: 'value'
    },
    series: [
      {
        name: '大学生就业人数',
        type: 'line',
        stack: 'Total',
        smooth: true,
        data: []
      },
      {
        name: '研究生就业人数',
        type: 'line',
        stack: 'Total',
        smooth: true,
        data: []
      }
    ]
  }

  export default {
    data() {
      return {
        admin: Cookies.get('admin') ? JSON.parse(Cookies.get('admin')) : {},
        linBox: null,
        timeRange: 'year',
        options: [
          {label:'2024', value: 'year'},
          {label:'2023', value: 'year1'},
          {label:'2022', value: 'year2'},
          {label:'2021', value: 'year3'},
        ]
      }
    },
    mounted() {
      this.load()
    },
    methods: {
      // load() {
      //   if (!this.lineBox) {
      //     this.lineBox = echarts.init(document.getElementById('line'))
      //   }
      //   request.get('/graduateStu/' + this.timeRange).then(res => {
      //     option.xAxis.data = res.data.date
      //     option.series[0].data = res.data.borrow
      //     option.series[1].data = res.data.retur
      //     this.lineBox.setOption(option)
      //   })
      // }
    }
  }
</script>

<style>
.input {
  width: 300px;
  }
</style>
