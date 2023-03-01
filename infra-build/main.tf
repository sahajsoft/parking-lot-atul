terraform {
    required_providers {
        aws = {
            source = "hashicorp/aws"
            version = "~> 4.16"
        }
    }
    required_version = ">= 1.2.0"
}

variable "access_key" {
    type = string
}

variable "secret_key" {
    type = string
}

provider "aws" {
    region = "us-west-2"
    access_key = "${ var.access_key }"
    secret_key = "${ var.secret_key }"
}

resource "aws_instance" "app_server" {
    ami = "ami-830c94e3"
    instance_type = "t2.micro"
    tags = {
        Name = "ParkingAppServerInstance"
    }
}

# output "remote_instance_ip" {
#   value="${aws_instance.web.public_ip}"
#}