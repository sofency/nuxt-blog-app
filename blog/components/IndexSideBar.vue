<template>
  <div class="sidebar">
    <div class="blog-info">
      <h2>博客信息</h2>
      <div class="info-detail">
        <div class="item">
          <div class="left">站长:</div>
          <div class="right">sofency</div>
        </div>
        <div class="item">
          <div class="left">文章总数:</div>
          <div class="right">123</div>
        </div>
        <div class="item">
          <div class="left">标签总数:</div>
          <div class="right">123</div>
        </div>
        <div class="item">
          <div class="left">评论总数:</div>
          <div class="right">123</div>
        </div>
        <div class="item">
          <div class="left">运行天数:</div>
          <div class="right">3个月</div>
        </div>
      </div>
    </div>
    <div class="blog-info">
      <h2>标签云</h2>
      <div class="tag-cloud">
        <span class="tag tag-level-1">标签1</span>
        <span class="tag tag-level-2">标签2</span>
        <span class="tag tag-level-3">标签3</span>
        <span class="tag tag-level-1">标签4</span>
        <span class="tag tag-level-2">标签5</span>
        <span class="tag tag-level-2">标签5</span>
        <span class="tag tag-level-2">标签5</span>
        <span class="tag tag-level-2">标签5</span>
        <span class="tag tag-level-2">标签5</span>
        <span class="tag tag-level-2">标签5</span>
        <span class="tag tag-level-2">标签5</span>
        <span class="tag tag-level-2">标签5</span>
        <span class="tag tag-level-2">标签5</span>
        <span class="tag tag-level-2">标签5</span>
        <span class="tag tag-level-2">标签5</span>
        <span class="tag tag-level-2">标签5</span>
      </div>
    </div>

    <div class="blog-info">
      <h2>访问统计</h2>
      <div class="about-statistic">
        <div class="card-content">
          <div class="statistic">
            <div><span>今日人数</span><span id="今日人数">50</span></div>
            <div><span>今日访问</span><span id="今日访问">64</span></div>
            <div><span>昨日人数</span><span id="昨日人数">51</span></div>
            <div><span>昨日访问</span><span id="昨日访问">72</span></div>
            <div><span>本月访问</span><span id="本月访问">765</span></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>
<style lang="less" scoped >
.sidebar {
  .blog-info {
    border: 2px solid #f5f5f6;
    padding: 10px 30px;
    border-radius: 10px;
    margin-left: 50px;
    margin-bottom: 30px;

    .about-statistic {
      min-height: 250px;
      background-size: cover;
      overflow: hidden;
      border-radius: 24px;
      background: var(--card-bg);
      border: transparent;
      box-shadow: 0 8px 16px -4px #2c2d300c;
      position: relative;
      overflow: hidden;
      transition: all 1s;
      .card-content {
        position: absolute;
        width: 100%;
        height: 100%;
        top: 0;
        left: 0;
        z-index: 2;
        display: flex;
        flex-direction: column;
        .statistic {
          border-radius: 15px;
          width: 100%;
          // color: #fff;
          display: flex;
          justify-content: space-between;
          flex-direction: row;
          flex-wrap: wrap;
          margin-top: 1rem;
          margin-bottom: 2rem;
          div {
            display: flex;
            justify-content: space-between;
            flex-direction: column;
            width: 50%;
            margin-bottom: 0.5rem;

            span:last-child {
              font-weight: 700;
              font-size: 34px;
              line-height: 1;
              white-space: nowrap;
            }
          }
        }
      }
    }

    .tag-cloud {
      display: flex;
      flex-wrap: wrap;
      align-items: center;
      gap: 10px; /* 使用 gap 属性设置标签之间的间距 */
    }
    .tag {
      display: inline-flex;
      align-items: center;
      justify-content: center;
      padding: 5px 10px;
      border-radius: 5px;
      background-color: #f0f0f0;
      color: #333;
      font-size: 14px;
      font-weight: bold;
      text-transform: uppercase; /* 所有标签文本大写 */
      transition: background-color 0.3s ease, transform 0.3s ease;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 添加阴影效果 */
    }
    .tag:hover {
      background-color: #ddd;
    }
    .tag-level-1 {
      font-size: 18px;
    }
    .tag-level-2 {
      font-size: 16px;
    }
    .tag-level-3 {
      font-size: 14px;
    }

    .info-detail {
      .item {
        display: flex;
        justify-content: space-between;
        align-items: center; /* 如果需要垂直居中 */
        height: 30px;
        line-height: 30px;
        border-bottom: 1px solid #f5f5f6;
        .right {
          margin-right: 10px;
        }
      }
    }
  }
}
</style>

