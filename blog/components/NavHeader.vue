<template>
  <div class="head-container" style="padding-left: 100px; padding-right: 100px">
    <div class="header">
      <div class="left">
        <div class="title">我的博客</div>
        <ul>
          <li><NuxtLink to="/">首页</NuxtLink></li>
          <li><NuxtLink to="/archive">归档</NuxtLink></li>
          <li><NuxtLink to="/resource">学习资料</NuxtLink></li>
          <li><NuxtLink to="/links">友链</NuxtLink></li>
          <li><NuxtLink to="/about">关于</NuxtLink></li>
        </ul>
      </div>
      <div class="right">
        <input class="search" placeholder="搜点..." />
        <a-icon class="icon" type="search" title="search" alt="搜索全文" />
      </div>
    </div>
  </div>
</template>

<style lang="less" scoped>
.head-container {
  position: fixed;
  top: 0px;
  z-index: 999;
  width: 100%;
  color: white;
  .header {
    height: 80px;
    width: 100%;
    line-height: 80px;
    font-size: 20px;
    position: relative;
    display: flex;
    .left {
      display: flex;
      .title {
        margin-right: 80px;
        font-size: 30px;
      }
      a {
        color: white;
      }
    }

    .right {
      line-height: 80px;
      position: absolute;
      box-sizing: border-box;
      right: 0px;
      .search {
        box-sizing: border-box;
        border: 1px solid #ced4da;
        padding-left: 5px;
        padding-right: 5px;
        height: 40px;
        line-height: 40px;
        margin-top: 20px;
        border-radius: 10px;
        font-size: 10px;
        width: 250px;
        background-color: transparent;
      }
      .icon {
        margin-left: -30px;
        vertical-align: sub;
      }
    }
  }
  ul {
    padding: 0;
    margin: 0;
  }
  ul li {
    display: inline-block;
    margin-right: 30px;
  }
}
</style>

<script>
export default {};
</script>