resource "local_file" "redis" {

  filename = "${path.module}/redis.txt"

  content = <<EOF
Enabled=${var.enabled}
EOF
}