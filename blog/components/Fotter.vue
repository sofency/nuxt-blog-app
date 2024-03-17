<template>
  <div class="fotter color-change">
    <div>©2022 - 2023 By Sofency</div>
    <div>豫ICP备2022022567号</div>
  </div>
</template>

<style scoped>
.fotter {
  margin-top: 40px;
  width: 100%;
  padding: 40px 20px;
  color: #eee;
  font-size: 14px;
  text-align: center;
  background: linear-gradient(-45deg, #ee7752, #ce3e75, #23a6d5, #23d5ab);
}
.color-change {
  animation: colorAnimation 5s ease infinite;
}
@keyframes colorAnimation {
  0% {
    background-position: 0 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0 50%;
  }
}
</style>