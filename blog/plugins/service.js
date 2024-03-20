// // api 请求后端服务 封装axios
// export default function ({ $axios, redirect, route, store }) {
//   // 基本配置
//   // $axios.defaults.timeout = 5000; // 超时时间


//   $axios.onRequest((config => {
//     // console.log("请求拦截", config);
//     // config.headers.token = store.state.user.token;
//     return config;
//   }))

//   // 返回
//   // $axios.onResponse((res => {
//   //   console.log("axios response", res);
//   //   // 判读返回数据状态码是否正确
//   //   if (res.data.err == 2 && route.fullPath !== '/login') {
//   //     redirect("/login?path=" + route.fullPath)
//   //   }
//   //   return res;
//   // }))

//   // 错误信息处理
//   $axios.onError(error => {
//     console.log(error);
//     return error;
//   })
// }